package com.movietime.service;

import com.movietime.dao.UserDao;
import com.movietime.entity.User;
import com.movietime.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    public boolean isRegistered(String username) {
        return userDao.findByUsername(username) != null;
    }

    public boolean checkPassword(String username, String password_input) {
        User user = userDao.findByUsername(username);
        return user.getPassword().equals(MD5Utils.encode(username + password_input));
    }

    public void registerUser(String username, String password, String firstName, String lastName) {
        User user = new User();
        user.setEmail(username);
        user.setPassword(MD5Utils.encode(username + password));
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setIconPath("/images/user_icon/p1.png");
        userDao.create(user);
    }

    public User getUserInstance(String username, String password) {
        User user = userDao.findByUsername(username);
        if (user.getPassword().equals(MD5Utils.encode(username + password)))
            return user;
        return null;
    }
}
