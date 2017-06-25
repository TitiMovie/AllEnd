package website;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import website.View.BannerforDisplay;
import website.View.MovieforDisplay;
import website.View.PanelforDisplay;
import website.View.TheaterforDisplay;

import java.util.Random;

@Controller
public class MainController {
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String get_homepage(Model model) {
        model.addAttribute("username", "Alice");
        model.addAttribute("usericon_path", "/images/user_icon/p1.png");
        model.addAttribute("bannerMovie_name", "Guardians of the Galaxy");
        model.addAttribute("banner_path", "/images/homepage/banner.jpg");

        BannerforDisplay [] bannerList = new BannerforDisplay[3];
        bannerList[0] = new BannerforDisplay("Guardians of the Galaxy", "/images/homepage/banner.jpg");
        bannerList[1] = new BannerforDisplay("Transformers 4", "/images/homepage/banner1.jpg");
        bannerList[2] = new BannerforDisplay("Game of Thrones", "/images/homepage/banner2.jpg");
        model.addAttribute("bannerList", bannerList);

        PanelforDisplay[] panelList = new PanelforDisplay[4];
        for (int i = 0; i < 4; i++) {
            panelList[i] = new PanelforDisplay();
        }

        panelList[0].name = "Featured";
        panelList[0].active = true;
        panelList[0].movieList = new MovieforDisplay[12];   // 注意：数组长度要刚刚好，模板实例化时会报错！
        panelList[0].movieList[0] = new MovieforDisplay("God’s Compass", "/images/homepage/featureMoviesImages/m15.jpg");
        panelList[0].movieList[1] = new MovieforDisplay("Bad Moms", "/images/homepage/featureMoviesImages/m2.jpg");
        panelList[0].movieList[2] = new MovieforDisplay("Jason Bourne", "/images/homepage/featureMoviesImages/m5.jpg");
        panelList[0].movieList[3] = new MovieforDisplay("Rezort", "/images/homepage/featureMoviesImages/m16.jpg");
        panelList[0].movieList[4] = new MovieforDisplay("Peter", "/images/homepage/featureMoviesImages/m17.jpg");
        panelList[0].movieList[5] = new MovieforDisplay("ISRA 88", "/images/homepage/featureMoviesImages/m18.jpg");
        panelList[0].movieList[6] = new MovieforDisplay("WAR DOGS", "/images/homepage/featureMoviesImages/m1.jpg");
        panelList[0].movieList[7] = new MovieforDisplay("The Other Side", "/images/homepage/featureMoviesImages/m14.jpg");
        panelList[0].movieList[8] = new MovieforDisplay("Civil War", "/images/homepage/featureMoviesImages/m19.jpg");
        panelList[0].movieList[9] = new MovieforDisplay("The Secret Life of Pets", "/images/homepage/featureMoviesImages/m20.jpg");
        panelList[0].movieList[10] = new MovieforDisplay("The Jungle Book", "/images/homepage/featureMoviesImages/m21.jpg");
        panelList[0].movieList[11] = new MovieforDisplay("Assassin's Creed 3", "/images/homepage/featureMoviesImages/m22.jpg");

        panelList[1].name = "Top viewed";
        panelList[1].active = false;
        panelList[1].movieList = new MovieforDisplay[2];
        panelList[1].movieList[0] = new MovieforDisplay("MovieforDisplay 3", "/images/homepage/featureMoviesImages/m3.jpg");
        panelList[1].movieList[1] = new MovieforDisplay("MovieforDisplay 4", "/images/homepage/featureMoviesImages/m4.jpg");

        panelList[2].name = "Top Rating";
        panelList[2].active = false;
        panelList[2].movieList = new MovieforDisplay[2];
        panelList[2].movieList[0] = new MovieforDisplay("MovieforDisplay 5", "/images/homepage/featureMoviesImages/m5.jpg");
        panelList[2].movieList[1] = new MovieforDisplay("MovieforDisplay 6", "/images/homepage/featureMoviesImages/m6.jpg");

        panelList[3].name = "Recently Added";
        panelList[3].active = false;
        panelList[3].movieList = new MovieforDisplay[2];
        panelList[3].movieList[0] = new MovieforDisplay("MovieforDisplay 7", "/images/homepage/featureMoviesImages/m7.jpg");
        panelList[3].movieList[1] = new MovieforDisplay("MovieforDisplay 8", "/images/homepage/featureMoviesImages/m8.jpg");

        model.addAttribute("panelList", panelList);

        return "homepage";
    }

    @RequestMapping(value="/selectShow", method = RequestMethod.POST)
    public String post_homepage(String movieName, Model model) {
        System.out.println("POST@'/selectShow': movieName='" + movieName + "'");

        model.addAttribute("username", "Alice");
        model.addAttribute("usericon_path", "/images/user_icon/p1.png");

        MovieforDisplay movie = new MovieforDisplay();
        movie.poster_path = "/images/selectShow/movie-show.jpg";
        movie.release_date = "Jul 10, 2015";
        movie.duration = "2 hrs 30 mins";
        movie.director = "S.S. Rajamouli.";
        movie.language = "Telugu";
        movie.genre = "Action, Romance";
        movie.cast_and_crew = "Prabhas as Amarendra Baahubali and Shivudu, Rana Daggubati as Bhallala Deva in Telugu and Palvaalthevan in Tamil, Anushka Shetty as Devasena, Tamannaah as Avantika, Sathyaraj as Kattappa, Nassar as Bijjala Deva in Telugu and Pingala Devan in Tamil, Ramya Krishnan as Sivagami";
        model.addAttribute("movie", movie);

        TheaterforDisplay[] theaterList = new TheaterforDisplay[2];
        theaterList[0] = new TheaterforDisplay();
        theaterList[0].name = "King Street Theater";
        theaterList[0].location = "123 Street";
        theaterList[0].showList = new String[2];
        theaterList[0].showList[0] = "08:32";
        theaterList[0].showList[1] = "11:33";

        theaterList[1] = new TheaterforDisplay();
        theaterList[1].name = "StoneBraker Theater";
        theaterList[1].location = "666 Street";
        theaterList[1].showList = new String[2];
        theaterList[1].showList[0] = "14:32";
        theaterList[1].showList[1] = "21:50";

        model.addAttribute("theaterList", theaterList);

        return "selectShow";
    }
    @RequestMapping("/login")
    public String login(Model model) {
        return "login";
    }
    @RequestMapping(value = "/try_login", method = RequestMethod.POST)
    @ResponseBody
    public String try_login(String email, String password, Model model) {
        System.out.println("Email:" + email + "\n" + "Password" + password + "\n");
        return "Email:" + email + "<br/>" + "Password:" + password + "<br/>";
    }
    @RequestMapping(value = "/try_register", method = RequestMethod.POST)
    @ResponseBody
    public String try_register(String first_name, String last_name, String email,
                            boolean newsletter, String password, String confirm_password, Model model) {
        return "first_name:" + first_name +
                "<br/>last_name:" + last_name +
                "<br/>Email:" + email +
                "<br/>Password:" + password +
                "<br/>confirm_password:" + confirm_password +
                "<br/>newsletter:" + (newsletter ? "true" : "false");
    }
    @RequestMapping("/register")
    public String register(Model model) {
        return "register";
    }
    @RequestMapping(value = "/selectSeat", method = RequestMethod.POST)
    public String selectSeat(String theater_name, String show, Model model) {
        System.out.println("POST@'/selectSeat': theater_name='" + theater_name + "', show='" + show + "'");

        model.addAttribute("username", "Alice");
        model.addAttribute("usericon_path", "/images/user_icon/p1.png");

        model.addAttribute("movie_name", "Gingerclown");
        model.addAttribute("show_time", "April 3, 21:00");
        model.addAttribute("price", 20);

        String[] seat_map = {  //Seating chart
                "aaaaaaaaaa",
                "aaaaaaaaaa",
                "__________",
                "aaaaaaaa__",
                "aaaaaaaaaa",
                "aaaaaaaaaa",
                "aaaaaaaaaa",
                "aaaaaaaaaa",
                "aaaaaaaaaa",
                "__aaaaaa__",
                "__aaaaaa__"
        };
        String [] sold_seat = {
                "1_2", "4_4", "4_5", "6_6", "6_7", "8_5", "8_6", "8_7", "8_8", "10_1", "10_2", "11_4"
        };
        model.addAttribute("seat_map",seat_map);
        model.addAttribute("sold_seat", sold_seat);

        return "selectSeat";
    }
    @RequestMapping(value = "/try_book_ticket", method = RequestMethod.POST)
    @ResponseBody
    public String try_bookTicket(String selectedList_JSON, Model model) {
        System.out.println(selectedList_JSON);

        int randNum = new Random().nextInt(3);
        return randNum % 2 == 0 ? "succeed" : "fail";
    }
    @RequestMapping(value = "/payment")
    public String payment(Model model) {
        model.addAttribute("username", "Alice");
        model.addAttribute("usericon_path", "/images/user_icon/p1.png");

        model.addAttribute("movie_name", "Baahubali");
        model.addAttribute("theater_name", "Lorem Ipsum");
        model.addAttribute("theater_location", "Trivandrum, Trivandrum");
        model.addAttribute("show_date", "Sat, 8 Aug, 2015");
        model.addAttribute("show_time", "11:30am");
        model.addAttribute("seat", "Balkani-s12(a)");
        model.addAttribute("total", 150);
        model.addAttribute("extra_fees_note", "+ (Internet handling fees : RMB. 42.00 (incl. of Service Tax))");
        model.addAttribute("grand_total", 192);

        return "payment";
    }
    @RequestMapping(value = "/try_payment", method = RequestMethod.POST)
    @ResponseBody
    public String try_finish_payment(String email, String phone, String card_number,
                                     String cvv, String card_holder_name, String valid_thru, Model model) {
        System.out.println("\nemail:" + email + "\nphone:" + phone + "\ncard_number:" +
                card_number + "\ncvv:" + cvv + "\ncard_holder_name:" + card_holder_name +
                "\nvalid_thru:" + valid_thru);

        int randNum = new Random().nextInt(3);
        return randNum % 2 == 0 ? "succeed" : "fail";
    }
}
