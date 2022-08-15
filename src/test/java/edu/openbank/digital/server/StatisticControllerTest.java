package edu.openbank.digital.server;

import edu.openbank.digital.user.User;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StatisticControllerTest {

    StatisticController statisticController = new StatisticController();

    @Test
    void formingList_true_1() {

        //expected
        List<UserStatisticDto> expected = new ArrayList<>();
        expected.add(new UserStatisticDto("Dina", true, "someaddress2"));

        // given
        Statistic statistic = new Statistic(1, Timestamp.valueOf("2022-08-11 16:19:50"));
        Boolean status = true;
        List<User> oldList = new ArrayList<>();
        oldList.add(new User(1, "someaddress1", "Sam", "gardener@mail.ru", Timestamp.valueOf("2022-08-11 16:39:50"), false));
        oldList.add(new User(2, "someaddress2", "Dina", "new@mail.ru", Timestamp.valueOf("2022-08-11 18:21:26"), true));
        oldList.add(new User(3, "someaddress3", "Tom", "Tom@mail.ru", Timestamp.valueOf("2022-08-11 16:14:50"), false));
        oldList.add(new User(4, "someaddress4", "Kate", "Kate@mail.ru", Timestamp.valueOf("2022-08-11 16:31:50"), false));

        //when
        List<UserStatisticDto> result = statisticController.formingList(oldList, statistic, status);

        //then
        if (expected.size() == result.size()) {
            for (int i = 0; i < expected.size(); i++) {
                assertEquals(expected.get(i).getName(), result.get(i).getName());
                assertEquals(expected.get(i).getIsOnline(), result.get(i).getIsOnline());
                assertEquals(expected.get(i).getUrl(), result.get(i).getUrl());
            }
        }
    }

    @Test
    void formingList_false_1() {

        //expected
        List<UserStatisticDto> expected = new ArrayList<>();
        expected.add(new UserStatisticDto("Sam", false, "someaddress1"));
        expected.add(new UserStatisticDto("Kate", false, "someaddress4"));

        // given
        Statistic statistic = new Statistic(1, Timestamp.valueOf("2022-08-11 16:19:50"));
        Boolean status = false;
        List<User> oldList = new ArrayList<>();
        oldList.add(new User(1, "someaddress1", "Sam", "gardener@mail.ru", Timestamp.valueOf("2022-08-11 16:39:50"), false));
        oldList.add(new User(2, "someaddress2", "Dina", "new@mail.ru", Timestamp.valueOf("2022-08-11 18:21:26"), true));
        oldList.add(new User(3, "someaddress3", "Tom", "Tom@mail.ru", Timestamp.valueOf("2022-08-11 16:14:50"), false));
        oldList.add(new User(4, "someaddress4", "Kate", "Kate@mail.ru", Timestamp.valueOf("2022-08-11 16:31:50"), false));

        //when
        List<UserStatisticDto> result = statisticController.formingList(oldList, statistic, status);

        //then
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).getName(), result.get(i).getName());
            assertEquals(expected.get(i).getIsOnline(), result.get(i).getIsOnline());
            assertEquals(expected.get(i).getUrl(), result.get(i).getUrl());
        }
    }

    @Test
    void formingList_true_0() {

        //expected
        List<UserStatisticDto> expected = new ArrayList<>();
        expected.add(new UserStatisticDto("Dina", true, "someaddress2"));

        // given
        Statistic statistic = new Statistic(0, Timestamp.valueOf("2022-08-11 16:19:50"));
        Boolean status = true;
        List<User> oldList = new ArrayList<>();
        oldList.add(new User(1, "someaddress1", "Sam", "gardener@mail.ru", Timestamp.valueOf("2022-08-11 16:39:50"), false));
        oldList.add(new User(2, "someaddress2", "Dina", "new@mail.ru", Timestamp.valueOf("2022-08-11 18:21:26"), true));
        oldList.add(new User(3, "someaddress3", "Tom", "Tom@mail.ru", Timestamp.valueOf("2022-08-11 16:14:50"), false));
        oldList.add(new User(4, "someaddress4", "Kate", "Kate@mail.ru", Timestamp.valueOf("2022-08-11 16:31:50"), false));

        //when
        List<UserStatisticDto> result = statisticController.formingList(oldList, statistic, status);

        //then
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).getName(), result.get(i).getName());
            assertEquals(expected.get(i).getIsOnline(), result.get(i).getIsOnline());
            assertEquals(expected.get(i).getUrl(), result.get(i).getUrl());
        }
    }

    @Test
    void formingList_false_0() {

        //expected
        List<UserStatisticDto> expected = new ArrayList<>();
        expected.add(new UserStatisticDto("Sam", false, "someaddress1"));
        expected.add(new UserStatisticDto("Tom", false, "someaddress3"));
        expected.add(new UserStatisticDto("Kate", false, "someaddress4"));

        // given
        Statistic statistic = new Statistic(0, Timestamp.valueOf("2022-08-11 16:19:50"));
        Boolean status = false;
        List<User> oldList = new ArrayList<>();
        oldList.add(new User(1, "someaddress1", "Sam", "gardener@mail.ru", Timestamp.valueOf("2022-08-11 16:39:50"), false));
        oldList.add(new User(2, "someaddress2", "Dina", "new@mail.ru", Timestamp.valueOf("2022-08-11 18:21:26"), true));
        oldList.add(new User(3, "someaddress3", "Tom", "Tom@mail.ru", Timestamp.valueOf("2022-08-11 16:14:50"), false));
        oldList.add(new User(4, "someaddress4", "Kate", "Kate@mail.ru", Timestamp.valueOf("2022-08-11 16:31:50"), false));

        //when
        List<UserStatisticDto> result = statisticController.formingList(oldList, statistic, status);

        //then
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).getName(), result.get(i).getName());
            assertEquals(expected.get(i).getIsOnline(), result.get(i).getIsOnline());
            assertEquals(expected.get(i).getUrl(), result.get(i).getUrl());
        }
    }

    @Test
    void formingList_null_1() {

        //expected
        List<UserStatisticDto> expected = new ArrayList<>();
        expected.add(new UserStatisticDto("Sam", false, "someaddress1"));
        expected.add(new UserStatisticDto("Dina", true, "someaddress2"));
        expected.add(new UserStatisticDto("Kate", false, "someaddress4"));

        // given
        Statistic statistic = new Statistic(1, Timestamp.valueOf("2022-08-11 16:19:50"));
        Boolean status = null;
        List<User> oldList = new ArrayList<>();
        oldList.add(new User(1, "someaddress1", "Sam", "gardener@mail.ru", Timestamp.valueOf("2022-08-11 16:39:50"), false));
        oldList.add(new User(2, "someaddress2", "Dina", "new@mail.ru", Timestamp.valueOf("2022-08-11 18:21:26"), true));
        oldList.add(new User(3, "someaddress3", "Tom", "Tom@mail.ru", Timestamp.valueOf("2022-08-11 16:14:50"), false));
        oldList.add(new User(4, "someaddress4", "Kate", "Kate@mail.ru", Timestamp.valueOf("2022-08-11 16:31:50"), false));

        //when
        List<UserStatisticDto> result = statisticController.formingList(oldList, statistic, status);

        //then
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).getName(), result.get(i).getName());
            assertEquals(expected.get(i).getIsOnline(), result.get(i).getIsOnline());
            assertEquals(expected.get(i).getUrl(), result.get(i).getUrl());
        }
    }

    @Test
    void formingList_null_0() {

        //expected
        List<UserStatisticDto> expected = new ArrayList<>();
        expected.add(new UserStatisticDto("Sam", false, "someaddress1"));
        expected.add(new UserStatisticDto("Dina", true, "someaddress2"));
        expected.add(new UserStatisticDto("Tom", false, "someaddress3"));
        expected.add(new UserStatisticDto("Kate", false, "someaddress4"));

        // given
        Statistic statistic = new Statistic(0, Timestamp.valueOf("2022-08-11 16:19:50"));
        Boolean status = null;
        List<User> oldList = new ArrayList<>();
        oldList.add(new User(1, "someaddress1", "Sam", "gardener@mail.ru", Timestamp.valueOf("2022-08-11 16:39:50"), false));
        oldList.add(new User(2, "someaddress2", "Dina", "new@mail.ru", Timestamp.valueOf("2022-08-11 18:21:26"), true));
        oldList.add(new User(3, "someaddress3", "Tom", "Tom@mail.ru", Timestamp.valueOf("2022-08-11 16:14:50"), false));
        oldList.add(new User(4, "someaddress4", "Kate", "Kate@mail.ru", Timestamp.valueOf("2022-08-11 16:31:50"), false));

        //when
        List<UserStatisticDto> result = statisticController.formingList(oldList, statistic, status);

        //then
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).getName(), result.get(i).getName());
            assertEquals(expected.get(i).getIsOnline(), result.get(i).getIsOnline());
            assertEquals(expected.get(i).getUrl(), result.get(i).getUrl());
        }
    }
}