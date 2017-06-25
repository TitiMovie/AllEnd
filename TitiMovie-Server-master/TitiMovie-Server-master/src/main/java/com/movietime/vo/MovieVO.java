package com.movietime.vo;


import java.util.Random;

public class MovieVO {
    private int id;
    private String name;
    private String posterPath;
    private String bannerPath;
    private String releaseDate;
    private String duration;
    private String director;
    private String language;
    private String genre;
    private String castAndCrew;

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

    public MovieVO() {
        this.id = new Random().nextInt();
    }

    public MovieVO(String name, String posterPath) {
        this.id = new Random().nextInt();
        this.name = name;
        this.posterPath = posterPath;
    }

    public MovieVO(String name, String posterPath, String bannerPath) {
        this(name, posterPath);
        this.bannerPath = bannerPath;
    }
}
