package com.yener.testproject.mock;

import com.yener.testproject.TestprojectApplication;
import com.yener.testproject.model.User;
import com.yener.testproject.repository.UserRepository;
import com.yener.testproject.service.UserServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ActiveProfiles("LOCAL")
@SpringBootTest(
        classes = TestprojectApplication.class)
public class UserServiceAnnotationTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Before
    void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void findUser() {
        List<User> userList = userServiceImpl.findUser("erhan");
        assertEquals(true, userList.isEmpty());
    }

    @Test
    void findUser2() {
        final String firstName = "erhan";
        final List<User> mockUserList = new ArrayList<>();

        Mockito.when(userServiceImpl.findUser(firstName)).thenReturn(mockUserList);
        List<User> userList = userServiceImpl.findUser(firstName);
        assertEquals(true, userList.isEmpty());
        assertEquals(mockUserList, userList);

        verify(userRepository).findUserList(firstName);
        verify(userRepository, times(1)).findUserList(firstName);
        verify(userRepository, atLeast(1)).findUserList(firstName);
        verify(userRepository, atMost(1)).findUserList(firstName);
    }

    @Test
    void testMethod() {
        String test="test";
        System.out.println(test.substring(0,4));
    }
}
