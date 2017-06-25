package com.movietime.service;

import com.movietime.entity.User;

public interface UserService {

    boolean isRegistered(String username);
    boolean checkPassword(String username, String passwordInput);
    void registerUser(String username, String password, String firstName, String lastName);
    User getUserInstance(String username, String password);
}
