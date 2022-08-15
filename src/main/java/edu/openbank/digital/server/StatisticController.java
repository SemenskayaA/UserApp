package edu.openbank.digital.server;

import edu.openbank.digital.user.User;
import edu.openbank.digital.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/server")
public class StatisticController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    StatisticRepository statisticRepository;

    @GetMapping
    public @ResponseBody
    StatisticDto getStatistic(@RequestBody RequestDto requestDto) throws IOException {

        Statistic statistic = statisticRepository.getReferenceById(requestDto.getIdStatistic());
        List<User> oldUserList = userRepository.findAll();

        return new StatisticDto(addStatistic(), formingList(oldUserList, statistic, requestDto.getStatus()));
    }

    List<UserStatisticDto> formingList(List<User> oldUserList, Statistic statistic, Boolean status) {
        List<UserStatisticDto> newUserList = new ArrayList<>();
        for (User user : oldUserList) {
            if (checkUser(user, status, statistic)) {
                UserStatisticDto userStatisticDto = new UserStatisticDto();
                userStatisticDto.setName(user.getName());
                userStatisticDto.setIsOnline(user.getIsOnline());
                userStatisticDto.setUrl(user.getUrl());
                newUserList.add(userStatisticDto);
            }
        }
        return newUserList;
    }

    private long addStatistic() {

        Statistic statistic = new Statistic();
        statistic.setTimeCreateStatistic(Timestamp.valueOf(LocalDateTime.now()));
        statisticRepository.save(statistic);

        return statistic.getStatisticId();
    }

    private boolean checkUser(User user, Boolean status, Statistic statistic) {

        boolean userHasDesiredStatus = status == null || (status == user.getIsOnline());
        boolean statusHasRelevantTime = statistic.getStatisticId() == 0 || statistic.getTimeCreateStatistic().before(user.getStatusChangeTime());

        return userHasDesiredStatus && statusHasRelevantTime;
    }
}
