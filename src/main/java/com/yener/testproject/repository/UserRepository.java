package com.yener.testproject.repository;

import com.yener.testproject.model.User;

import java.util.List;

public interface UserRepository {
    List<User> findUserList(String firstName);
}
