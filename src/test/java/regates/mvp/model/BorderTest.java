package regates.mvp.model;

import javafx.scene.image.Image;
import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

public class BorderTest {

    @Test
    public void testGeneratePoints() {
        Border b = new Border();
        b.setBarycentre(new Coordinate(0, 0));
        b.generateBordersForImage(new Image(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResourceAsStream("img/ship.png"))), 45, 56);
        Assert.assertEquals(1191, b.getPoints().size());
        Assert.assertEquals(24, b.getImgShift().getX(), 1.);
        Assert.assertEquals(28, b.getImgShift().getY(), 1.);
    }

    @Test
    public void testRotate() {
        Border b = new Border();
        b.setBarycentre(new Coordinate(0, 0));
        b.generateBordersForImage(new Image(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResourceAsStream("img/ship.png"))), 45, 56);
        b.rotate(180);
        Coordinate expected = new Coordinate(16, 14);
        Assert.assertEquals(expected.getY(), b.getPoints().get(0).getY(), 1);
        Assert.assertEquals(expected.getX(), b.getPoints().get(0).getX(), 1);
    }


}
