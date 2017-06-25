package com.movietime.dao;

import com.movietime.entity.User;


public interface UserDao {

    public void create(User user);
    public User findOne(long id);
    public User findByUsername(String username);
}
