package com.movietime.controller;

import com.movietime.entity.Movie;
import com.movietime.entity.User;
import com.movietime.service.MovieService;
import com.movietime.service.TagService;
import com.movietime.util.Converter;
import com.movietime.vo.BannerVO;
import com.movietime.vo.MovieVO;
import com.movietime.vo.PanelVO;
import com.movietime.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping(value = {"/", "/homepage", "/index", "/index.html"})
public class HomePageController {
    @Autowired
    MovieService ms;
    @Autowired
    TagService ts;

    @RequestMapping(method = RequestMethod.GET)
    public String get_homepage(Model model, HttpSession session) {
        // 登录状态
        User user = (User) session.getAttribute("user");
        if (user != null) {
            UserVO userVO = (UserVO) Converter.convert(user);
            model.addAttribute("username", userVO.getUsername());
            model.addAttribute("usericon_path", userVO.getIconPath());
        }

        List<Movie> movieList = ms.findAll();
        // 从数据库获取banner，注入模型
        List<BannerVO> bannerList = new LinkedList<BannerVO>();
        List<Movie> toBeDeleted = new LinkedList<Movie>();
        for (int i = 0; i < movieList.size(); i++) {
            Movie movie = movieList.get(i);
            if (movie.getBannerPath() != null) {
                bannerList.add(new BannerVO((int) movie.getId(), movie.getName(), movie.getBannerPath()));
                toBeDeleted.add(movie);
            }
        }
        movieList.removeAll(toBeDeleted);

        if (bannerList.size() == 0) {
            System.err.println("WARNING: BannerList is empty");
        } else {
            model.addAttribute("bannerList", bannerList.toArray());
        }

        // 从数据库获取panel，注入模型. 每个panel与数据库中的tag对应
        List<String> tagList = ts.findAllName();
        PanelVO[] panelList = new PanelVO[tagList.size()];
        for (int i = 0; i < tagList.size(); i++) {
            // 将panel元数据注入模型
            String tag = tagList.get(i);
            panelList[i] = new PanelVO();
            panelList[i].setName(tag);
            if (i == 0) panelList[i].setActive(true);
            // 将与该panel相关的电影注入模型
            List<Movie> relevantMovieList = ms.findByTagName(tag);
            List<Movie> noPosterList = new LinkedList<Movie>(); // 排除没有poster的电影
            for (Movie movie : relevantMovieList) {
                if (movie.getPosterPath() == null)
                    noPosterList.add(movie);
            }
            relevantMovieList.removeAll(noPosterList);
            panelList[i].setMovieList(Converter.convert(relevantMovieList).toArray(new MovieVO[1]));
        }
        model.addAttribute("panelList", panelList);
        return "homepage";
    }
}
