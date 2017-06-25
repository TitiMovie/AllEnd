package website.View;

import java.util.Random;

/**
 * Created by yangzy on 2017/5/7.
 */
public class PanelforDisplay {
    public String name;
    public MovieforDisplay [] movieList;
    public boolean active;
    public int id;

    public PanelforDisplay() {
        active = false;
        id = new Random().nextInt();
    }
}
