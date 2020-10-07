package regates.mvp.model;

import javafx.scene.image.Image;
import org.junit.Assert;
import org.junit.Test;
import regates.mvp.model.boat.BoatObserver;

import java.util.Objects;

public class GameTest {

    @Test
    public void testStartStopGame() throws Exception {
        Game g = new Game();
        int before = Thread.activeCount();
        g.start();
        Assert.assertEquals(before + 1, Thread.activeCount());
        g.stop();
    }

    @Test
    public void testgetAngle() throws Exception {
        Game g = new Game();
        Assert.assertEquals(Integer.valueOf(1), g.getBoat().getAngle().getValue());
    }

    @Test
    public void testAddObserver() throws Exception {
        Game g = new Game();
        BoatObserver bo = boat -> {
        };
        Assert.assertEquals(0, g.getBoat().getBoatObservers().size());
        g.setObserver(bo);
        Assert.assertEquals(1, g.getBoat().getBoatObservers().size());
    }

    @Test
    public void testGetOrder() throws Exception {
        Game g = new Game();
        Assert.assertEquals(0, g.getOrder());
    }

    @Test
    public void testTestBuoyCollision() throws Exception {
        Game g = new Game();
        g.getBoat().getBorders().setBarycentre(new Coordinate(0, 0));
        g.getBoat().getBorders().generateBordersForImage(new Image(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResourceAsStream("img/ship.png"))), 45, 56);
        Board.getInstance().getBuoys().add(new Buoy(100, new Coordinate(0, 0)));

        Assert.assertTrue(g.testBuoyCollision());
    }

    @Test
    public void testTestCoastCollision() throws Exception {
        Game g = new Game();
        g.getBoat().getBorders().setBarycentre(new Coordinate(1100, 400));
        g.getBoat().getBorders().generateBordersForImage(new Image(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResourceAsStream("img/ship.png"))), 45, 56);


        Assert.assertFalse(g.testCoastCollision());
    }

    @Test
    public void testTestCheckpointID() throws Exception {
        Game g = new Game();
        g.getBoat().getBorders().setBarycentre(new Coordinate(1100, 400));
        g.getBoat().getBorders().generateBordersForImage(new Image(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResourceAsStream("img/ship.png"))), 45, 56);

        Assert.assertFalse(g.testCheckpoint(0));
        g.getBoat().getBorders().resetTranslation();
        g.getBoat().getBorders().setBarycentre(new Coordinate(600, 270));
        g.getBoat().getBorders().translateBorders();
        Assert.assertTrue(g.testCheckpoint(0));

    }

}
