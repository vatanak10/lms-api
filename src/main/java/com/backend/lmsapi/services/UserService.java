package com.backend.lmsapi.services;

import java.util.List;

import com.backend.lmsapi.model.User;

public interface UserService {
    List<User> getAllUsers();

    User getUser(String username);

    User addUser(User user);
}
