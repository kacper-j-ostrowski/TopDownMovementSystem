package test;

import main.Input;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class InputTest {

    @Test
    public void test_input_entries() {
        assertEquals(false, Input.getState(2));
        assertEquals(false, Input.getState(4));
        assertEquals(false, Input.getState(6));
        assertEquals(false, Input.getState(8));
    }

    @Test
    public void test_pressing_keys() {
        Input.press(2);
        assertEquals(true, Input.getState(2));
    }

    @Test
    public void test_realasing_keys() {
        Input.release(2);
        assertEquals(false, Input.getState(2));
    }


    @Test
    public void test_pressing_and_realasing_keys() {
        Input.press(2);
        assertEquals(true, Input.getState(2));
        Input.release(2);
        assertEquals(false, Input.getState(2));
    }
}
