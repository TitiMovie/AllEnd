package website.View;


// 这个类用于传输给模板
public class MovieforDisplay {
    public String name; // 注意：属性名在模板里有使用，不要轻易修改！
    public String poster_path;
    public String release_date;
    public String duration;
    public String director;
    public String language;
    public String genre;
    public String cast_and_crew;

    public MovieforDisplay() {}
    public MovieforDisplay(String name, String poster_path) {this.name = name; this.poster_path = poster_path;}
}
