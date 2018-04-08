package test;

import main.Input;
import main.PlayerMovement;
import main.Tile;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PlayerMovementTest {

    PlayerMovement playerMovement;

    @Before
    public void setUp() {
        playerMovement = new PlayerMovement(0,0);
    }

    @Test
    public void test_changing_direction() {
        Input.press(8);
        playerMovement.update();
        Input.press(2);
        playerMovement.update();
        assertEquals(playerMovement.getDirection(), 2);
        assertEquals(playerMovement.getPosition(), new Tile(0,0));
    }


    @Test
    public void test_moving() {
        Input.press(8);
        playerMovement.update();
        playerMovement.update();
        assertEquals(playerMovement.getDirection(), 8);
        assertEquals(playerMovement.getPosition(), new Tile(0,2));
    }


    @Test
    public void test_move_and_change_direction() {
        Input.press(8);
        playerMovement.update();
        playerMovement.update();
        assertEquals(playerMovement.getDirection(), 8);
        assertEquals(playerMovement.getPosition(), new Tile(0,1));

        Input.press(6);
        playerMovement.update();
        playerMovement.update();
        assertEquals(playerMovement.getDirection(), 6);
        assertEquals(playerMovement.getPosition(), new Tile(1,1));
    }


    @Test
    public void test_move_change_direction_and_release() {
        Input.press(8);
        playerMovement.update();
        playerMovement.update();
        assertEquals(playerMovement.getDirection(), 8);
        assertEquals(playerMovement.getPosition(), new Tile(0,1));

        Input.press(6);
        playerMovement.update();
        playerMovement.update();
        assertEquals(playerMovement.getDirection(), 6);
        assertEquals(playerMovement.getPosition(), new Tile(1,1));

        Input.release(6);
        playerMovement.update();
        playerMovement.update();
        assertEquals(playerMovement.getDirection(), 8);
        assertEquals(playerMovement.getPosition(), new Tile(1,2));
    }



    @Test
    public void test_press_and_release_many_times() {
        Input.press(8);
        playerMovement.update();
        playerMovement.update();
        assertEquals(playerMovement.getDirection(), 8);
        assertEquals(playerMovement.getPosition(), new Tile(0,1));

        Input.press(6);
        playerMovement.update();
        playerMovement.update();
        assertEquals(playerMovement.getDirection(), 6);
        assertEquals(playerMovement.getPosition(), new Tile(1,1));

        Input.release(6);
        playerMovement.update();
        playerMovement.update();
        assertEquals(playerMovement.getDirection(), 8);
        assertEquals(playerMovement.getPosition(), new Tile(1,2));

        Input.press(2);
        playerMovement.update();
        playerMovement.update();
        assertEquals(playerMovement.getDirection(), 2);
        assertEquals(playerMovement.getPosition(), new Tile(1,1));

        Input.press(6);
        playerMovement.update();
        playerMovement.update();
        assertEquals(playerMovement.getDirection(), 6);
        assertEquals(playerMovement.getPosition(), new Tile(2,1));

        Input.press(4);
        playerMovement.update();
        playerMovement.update();
        assertEquals(playerMovement.getDirection(), 4);
        assertEquals(playerMovement.getPosition(), new Tile(1,1));

        Input.release(2);
        playerMovement.update();
        playerMovement.update();
        assertEquals(playerMovement.getDirection(), 4);
        assertEquals(playerMovement.getPosition(), new Tile(-1,1));

        Input.release(4);
        playerMovement.update();
        playerMovement.update();
        assertEquals(playerMovement.getDirection(), 6);
        assertEquals(playerMovement.getPosition(), new Tile(0,1));

        Input.release(6);
        playerMovement.update();
        playerMovement.update();
        assertEquals(playerMovement.getDirection(), 8);
        assertEquals(playerMovement.getPosition(), new Tile(0,2));

        Input.release(8);
        playerMovement.update();
        playerMovement.update();
        assertEquals(playerMovement.getDirection(), 8);
        assertEquals(playerMovement.getPosition(), new Tile(0,2));
    }
}
