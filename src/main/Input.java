package main;

import java.util.HashMap;

public class Input {

    public static HashMap<Integer, Boolean> keys = new HashMap<>();
    static {
        keys.put(2, false);
        keys.put(4, false);
        keys.put(6, false);
        keys.put(8, false);
    }

    public static boolean getState(int key) {
        return keys.get(key);
    }

    public static void release(int key) {
        keys.replace(key, false);
    }

    public static void press(int key) {
        keys.replace(key, true);
    }

    public static void clear() {
        keys = new HashMap<>();
        keys.put(2, false);
        keys.put(4, false);
        keys.put(6, false);
        keys.put(8, false);
    }
}
