package com.movietime.vo;

import java.util.Random;

public class ScheduleVO {
    private int id;
    private String name;
    private String location;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ShowVO[] getShowList() {
        return showList;
    }

    public void setShowList(ShowVO[] showList) {
        this.showList = showList;
    }

    private ShowVO[] showList;

    public ScheduleVO() {
        this.id = new Random().nextInt();
    }
}
