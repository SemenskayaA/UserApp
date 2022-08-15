package edu.openbank.digital.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public @ResponseBody IdDto addNewUser (@RequestBody UserDto userDto){

        User user = setUserParam(userDto);

        userRepository.save(user);

        return setIdDto(user);
    }

    User setUserParam(UserDto userDto){

        User user = new User();

        user.setUrl(userDto.getUrl());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());

        return user;
    }

    IdDto setIdDto(User user){

        IdDto idDto = new IdDto();
        idDto.setId(user.getId());

        return idDto;
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody UserDto getUser(@PathVariable long id) throws IOException {

        User user = userRepository.getReferenceById(id);
        return setUserDtoParam(user);
    }

    UserDto setUserDtoParam(User user){

        UserDto userDto = new UserDto();

        userDto.setUrl(user.getUrl());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());

        return userDto;
    }

    @PutMapping
    public @ResponseBody StatusDto changeStatus(@RequestBody StatusDto statusDto){
        User user = userRepository.getReferenceById(statusDto.getUserId());

        statusDto.setIsOnlineLast(user.getIsOnline());

        user.setIsOnline(statusDto.getIsOnlineActual());
        user.setStatusChangeTime(Timestamp.valueOf(LocalDateTime.now()));

        userRepository.save(user);

        return statusDto;
    }

    @PostMapping("/image")
    public ImageDto saveImage(@RequestBody MultipartFile multipartFile) throws IOException{
        String filename = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        String uploadDir = "src/main/java/edu/openbank/digital/user/image/";
        FileUploadUtil.saveFile(uploadDir,filename,multipartFile);

        ImageDto imageDto = new ImageDto();
        imageDto.setUri("user/image/" + filename);

        return imageDto;
    }
}
