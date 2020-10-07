package regates.mvp.model;

import org.junit.Assert;
import org.junit.Test;

public class BoardTest {

    @Test
    public void testGetInstance() throws Exception {
        new Game();
        Board c = Board.getInstance();
        Assert.assertEquals(8, c.getCheckpoints().size());
        Assert.assertEquals(1, c.getCheckpoint(0).getOrder());
        Assert.assertEquals(0, c.getWind().getDirection(), 0);
    }
}
