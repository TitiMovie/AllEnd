package com.movietime.entity;

import java.io.Serializable;

public class TagMovie implements Serializable {
    private static final long serialVersionUID = 1L;
    private long tagId;
    private long movieId;

    public long getTagId() {
        return tagId;
    }

    public void setTagId(long tagId) {
        this.tagId = tagId;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }
}
