package com.yener.testproject.service;

import com.yener.testproject.model.User;
import com.yener.testproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl {

    @Autowired
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findUser(String firstName) {
        List<User> userList = userRepository.findUserList(firstName);
        return userList;
    }
}
