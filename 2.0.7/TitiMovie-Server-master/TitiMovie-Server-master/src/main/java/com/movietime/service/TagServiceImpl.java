package com.movietime.service;

import com.movietime.dao.MovieDao;
import com.movietime.dao.TagDao;
import com.movietime.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    TagDao tagDao;

    public List<String> findAllName() {
        return tagDao.findAllName();
    }
}
