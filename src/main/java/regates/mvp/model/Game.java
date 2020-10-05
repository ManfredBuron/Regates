package regates.mvp.model;

import lombok.Getter;

import java.util.Timer;
import java.util.TimerTask;

@Getter
public class Game {
    @Getter
    private Timer t;
    private TimerTask tt;
    private String configurationFilename;
    private Boat boat;

    public Game() {
        this.boat = new Boat(1, new Coordinate(200, 200));
        tt = new TimerTask() {
            @Override
            public void run() {
                // Calcule des nouvelles coordonnées
                boat.move(4);
                boat.notifyObservers();
            }
        };
        t = new Timer();
        t.scheduleAtFixedRate(tt, 0, 100);
    }

    public Boat getBoat() {
        return this.boat;
    }

    public void setObserver(BoatObserver bo) {
        this.boat.addObserver(bo);
    }


    public void launchGame(String s) {

    }
}
