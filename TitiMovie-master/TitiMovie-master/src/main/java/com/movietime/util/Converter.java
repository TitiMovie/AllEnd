package com.movietime.util;

import com.movietime.entity.Movie;
import com.movietime.entity.Show;
import com.movietime.entity.User;
import com.movietime.vo.MovieVO;
import com.movietime.vo.ShowVO;
import com.movietime.vo.UserVO;

import java.util.LinkedList;
import java.util.List;

public class Converter {
    public static MovieVO convert(Movie movie) {
        MovieVO movieVO = new MovieVO();
        movieVO.setBannerPath(movie.getBannerPath());
        movieVO.setCastAndCrew(movie.getCastAndCrew());
        movieVO.setDirector(movie.getDirector());
        movieVO.setDuration(movie.getDuration());
        movieVO.setGenre(movie.getGenre());
        movieVO.setId((int) movie.getId());
        movieVO.setLanguage(movie.getLanguage());
        movieVO.setName(movie.getName());
        movieVO.setPosterPath(movie.getPosterPath());
        movieVO.setReleaseDate(movie.getReleaseDate());
        return movieVO;
    }

    public static List<MovieVO> convert(List<Movie> movie) {
        List<MovieVO> mfd = new LinkedList<MovieVO>();
        for (Movie aMovie : movie) mfd.add(Converter.convert(aMovie));
        return mfd;
    }

    public static ShowVO convert(Show show) {
        ShowVO showVO = new ShowVO();
        showVO.setId(show.getId());
        showVO.setMovieId(show.getMovieId());
        showVO.setPrice(show.getPrice());
        showVO.setSeatMap(show.getSeatMap().split("\\|"));
        showVO.setTheaterName(show.getTheaterName());
        showVO.setTime(show.getTime());
        return showVO;
    }

    public static UserVO convert(User user) {
        UserVO userVO = new UserVO();
        userVO.setUsername(user.getFirstName() + " " + user.getLastName());
        userVO.setIconPath(user.getIconPath());
        return userVO;
    }
}
