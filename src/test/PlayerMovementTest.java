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
        Input.press(2);
        playerMovement.update();
        assertEquals(playerMovement.getDirection(), 2);
        assertEquals(playerMovement.getPosition(), new Tile(0,0));
    }

}
