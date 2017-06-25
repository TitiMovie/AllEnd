package com.movietime.entity;

import java.io.Serializable;
import java.util.Random;

public class Movie implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    private String name;
    private String posterPath;
    private String bannerPath;
    private String releaseDate;
    private String duration;
    private String director;
    private String language;
    private String genre;
    private String castAndCrew;

    public Movie() {
        this.id = new Random().nextInt();
    }

    public Movie(String name, String poster_path) {
        this.id = new Random().nextInt();
        this.name = name;
        this.posterPath = poster_path;
    }

    public Movie(String name, String poster_path, String banner_path) {
        this(name, poster_path);
        this.posterPath = banner_path;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getBannerPath() {
        return bannerPath;
    }

    public void setBannerPath(String bannerPath) {
        this.bannerPath = bannerPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCastAndCrew() {
        return castAndCrew;
    }

    public void setCastAndCrew(String castAndCrew) {
        this.castAndCrew = castAndCrew;
    }
}
