package com.movietime.controller;

import com.movietime.entity.Movie;
import com.movietime.entity.Seat;
import com.movietime.entity.Show;
import com.movietime.entity.User;
import com.movietime.service.MovieService;
import com.movietime.service.SeatService;
import com.movietime.service.ShowService;
import com.movietime.util.Converter;
import com.movietime.vo.UserVO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping(value = "/selectSeat/cinema/{cinema_id}")
public class SelectSeatPageController {
    @Autowired
    MovieService ms;
    @Autowired
    ShowService ss;
    @Autowired
    SeatService ses;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String post_selectSeat(int show_id, String selectedList_JSON, Model model, HttpSession session) {
        System.out.println("POST@'/selectSeat': show_id=" + show_id + ", selectedList_JSON=");
        System.out.println(selectedList_JSON);
        JSONArray jsonArray = JSONArray.fromObject(selectedList_JSON);
        List<Seat> seatList = new LinkedList<Seat>();
        Show show = ss.findOne(show_id);
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = JSONObject.fromObject(jsonArray.get(i));
            Seat seat = new Seat();
            seat.setRow((Integer) jsonObject.get("row"));
            seat.setCol((Integer) jsonObject.get("col"));
            seat.setBooked(true);
            seat.setShowId(show.getId());
            seatList.add(seat);
        }
        if (session.getAttribute("user") == null)
            return "LoginError";
        return ses.book(seatList) ? "succeed" : "SeatChosenError";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String get_selectSeat(@PathVariable("cinema_id") int theater_id,
                                 @RequestParam("movie_id") int movie_id,
                                 @RequestParam("show_id") int show_id,
                                 Model model,
                                 HttpSession session) {
        System.out.println("GET@'/selectSeat': theater_id='" + theater_id + "', show_id='" + show_id + "'");

        Movie movie = ms.findOne(movie_id);
        Show show = ss.findOne(show_id);
        // 检查参数正确性
        if (movie == null || show == null)
            return "redirect:/";

        // 登录状态
        User user = (User) session.getAttribute("user");
        if (user != null) {
            UserVO userVO = (UserVO) Converter.convert(user);
            model.addAttribute("username", userVO.getUsername());
            model.addAttribute("usericon_path", userVO.getIconPath());
        }

        // 电影&场次信息
        model.addAttribute("movie_name", movie.getName());
        model.addAttribute("show_time", show.getTime());
        model.addAttribute("show_id", show.getId());
        model.addAttribute("price", show.getPrice());
        model.addAttribute("seatMap", ses.getSeatMap(show.getId()));
        model.addAttribute("soldSeat", ses.getSoldSeat(show.getId()));

        return "selectSeat";
    }
}
