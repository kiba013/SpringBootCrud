package com.boot.service;

import com.boot.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUsers();

    User updateUser(User user, Long id);

    void deleteUser(Long id);

    User findUserById(Long id);
}
