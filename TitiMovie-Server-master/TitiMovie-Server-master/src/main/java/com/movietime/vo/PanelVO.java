package com.movietime.vo;

import java.util.Random;

public class PanelVO {
    private String name;
    private MovieVO[] movieList;
    private boolean active;
    private int id;

    public PanelVO() {
        active = false;
        id = new Random().nextInt();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MovieVO[] getMovieList() {
        return movieList;
    }

    public void setMovieList(MovieVO[] movieList) {
        this.movieList = movieList;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
