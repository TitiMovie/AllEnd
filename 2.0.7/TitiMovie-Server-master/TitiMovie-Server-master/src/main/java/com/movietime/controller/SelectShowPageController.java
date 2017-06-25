package com.movietime.controller;

import com.movietime.entity.Movie;
import com.movietime.entity.Show;
import com.movietime.entity.User;
import com.movietime.service.MovieService;
import com.movietime.service.SeatService;
import com.movietime.service.ShowService;
import com.movietime.util.Converter;
import com.movietime.vo.ScheduleVO;
import com.movietime.vo.ShowVO;
import com.movietime.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = {"/selectShow", "/selectShow.html"})
public class SelectShowPageController {
    @Autowired
    MovieService ms;
    @Autowired
    ShowService ss;
    @Autowired
    SeatService ses;

    @RequestMapping(method = RequestMethod.GET)
    public String get_selectShow(@RequestParam("movie_id") int movie_id,
                                 Model model,
                                 HttpSession session) {
        System.out.println("GET@'/selectShow': movie_id='" + movie_id + "'");

        Movie movie = ms.findOne(movie_id);
        // 检查参数正确性
        if (movie == null)
            return "redirect:/";

        // 登录状态
        User user = (User) session.getAttribute("user");
        if (user != null) {
            UserVO userVO = (UserVO) Converter.convert(user);
            model.addAttribute("username", userVO.getUsername());
            model.addAttribute("usericon_path", userVO.getIconPath());
        }

        // 将电影信息加入模型
        model.addAttribute("movie", Converter.convert(movie));

        // 将场次按电影院归类
        List<Show> showList = ss.findByMovie(movie_id);
        Map<String, List<Show>> showsGroupByTheater = new HashMap<String, List<Show>>();
        for (Show show : showList) {
            List<Show> showInThisTheater = showsGroupByTheater.get(show.getTheaterName());
            if (showInThisTheater == null)
                showInThisTheater = new LinkedList<Show>();
            showInThisTheater.add(show);
            showsGroupByTheater.put(show.getTheaterName(), showInThisTheater);
        }
        // 归类后的场次输出到模型
        List<ScheduleVO> scheduleList = new LinkedList<ScheduleVO>();
        for (String theater : showsGroupByTheater.keySet()) {
            List<Show> showInThisTheaterList = showsGroupByTheater.get(theater);
            ScheduleVO schedule = new ScheduleVO();
            schedule.setName(theater);
            schedule.setLocation("");
            schedule.setShowList(new ShowVO[showInThisTheaterList.size()]);
            for (int i = 0; i < showInThisTheaterList.size(); i++) {
                Show show = showInThisTheaterList.get(i);
                schedule.getShowList()[i] = Converter.convert(show);
                schedule.getShowList()[i].setSoldSeat(ses.getSoldSeat(show.getId()));
            }
            scheduleList.add(schedule);
        }

        model.addAttribute("theaterList", scheduleList.toArray());

        return "selectShow";
    }
}
