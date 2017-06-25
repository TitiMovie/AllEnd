package com.movietime.service;

import com.movietime.dao.MovieDao;
import com.movietime.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieDao movieDao;

    public Movie findOne(long id) {
        return movieDao.findOne(id);
    }

    public List<Movie> findAll() {
        return movieDao.findAll();
    }

    public List<Movie> findByTagName(String tagName) {
        return movieDao.findByTagName(tagName);
    }
}
