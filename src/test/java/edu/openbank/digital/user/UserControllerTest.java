package edu.openbank.digital.user;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static org.junit.jupiter.api.Assertions.*;


class UserControllerTest {

    UserController userController = new UserController();

    @Test
    void setUserParam_positiveTest() {

        //expected
        User expected = new User("someAddress", "Kate", "Kate@mail.ru");

        // given
        UserDto userDto = new UserDto("someAddress", "Kate", "Kate@mail.ru");

         //when
        User result = userController.setUserParam(userDto);

        //then
        assertEquals(expected.getName(), result.getName());
        assertEquals(expected.getEmail(), result.getEmail());
        assertEquals(expected.getUrl(), result.getUrl());
        //assertThat(expected, equalTo(result));
    }

    @Test
    void setIdDto_positiveTest() {

        //expected
        IdDto expected = new IdDto();
        expected.setId(1);

        // given
        User user = new User();
        user.setId(1);

        //when
        IdDto result = userController.setIdDto(user);

        //then
        assertEquals(expected.getId(), result.getId());
    }

    @Test
    void setUserDtoParam_positiveTest() {

        //expected
        UserDto expected = new UserDto("someAddress", "Kate", "Kate@mail.ru");


        // given
        User user = new User("someAddress", "Kate", "Kate@mail.ru");


        //when
        UserDto result = userController.setUserDtoParam(user);

        //then
        assertEquals(expected.getName(), result.getName());
        assertEquals(expected.getEmail(), result.getEmail());
        assertEquals(expected.getUrl(), result.getUrl());
    }

    @Test
    void changeStatus_positiveTest() {

    }

    @Test
    void saveImage_positiveTest() {
    }
}