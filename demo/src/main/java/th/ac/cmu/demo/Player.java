package th.ac.cmu.demo;

public class Player {
    public final String name;
    public Integer clicked;
    public Player(String name){
        this.name = name;
        this.clicked = 0;
    }
    public String getName() {
        return name;
    }

    public Integer getClicked() {
        return clicked;
    }


}
