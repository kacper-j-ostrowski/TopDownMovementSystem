package test;

import main.Tile;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TileTest {

    @Test
    public void test_equality() {
        Tile tile1 = new Tile(3,4);
        Tile tile2 = new Tile(3,4);
        assertEquals(tile1, tile2);
    }

    @Test
    public void test_non_equality() {
        Tile tile1 = new Tile(3,4);
        Tile tile2 = new Tile(3,5);
        assertNotEquals(tile1, tile2);

        tile1 = new Tile(3,4);
        tile2 = new Tile(4,4);
        assertNotEquals(tile1, tile2);

        tile1 = new Tile(2,6);
        tile2 = new Tile(4,4);
        assertNotEquals(tile1, tile2);
    }

}
