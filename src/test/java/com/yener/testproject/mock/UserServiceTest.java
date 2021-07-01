package com.yener.testproject.mock;

import com.yener.testproject.model.User;
import com.yener.testproject.repository.UserRepository;
import com.yener.testproject.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Test
    void findUser() {
        final UserRepository mockUserRepository = Mockito.mock(UserRepository.class);
        final UserServiceImpl userService = new UserServiceImpl(mockUserRepository);
        final List<User> userList = userService.findUser("erhan");
        assertEquals(true, userList.isEmpty());

    }

    @Test
    void findUser2() {
        final String firstName = "erhan";
        final UserRepository mockUserRepository = Mockito.mock(UserRepository.class);

        final List<User> mockUserList = new ArrayList<>();
        Mockito.when(mockUserRepository.findUserList(firstName)).thenReturn(mockUserList);

        final UserServiceImpl userService = new UserServiceImpl(mockUserRepository);
        List<User> userList = userService.findUser(firstName);
        assertEquals(true, userList.isEmpty());
        assertEquals(mockUserList, userList);

        //UserService find user list metod cagrısını yaptı mı kontrolü?
        verify(mockUserRepository).findUserList(firstName);

        verify(mockUserRepository, times(1)).findUserList(firstName);
        verify(mockUserRepository, atLeast(1)).findUserList(firstName);
        verify(mockUserRepository, atMost(1)).findUserList(firstName);

    }
}