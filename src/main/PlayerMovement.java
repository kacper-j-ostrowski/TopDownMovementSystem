package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PlayerMovement {

    private static final int UP = 8;
    private static final int DOWN = 2;
    private static final int LEFT = 4;
    private static final int RIGHT = 6;

    private int direction;
    private Tile position;
    private ArrayList<HashMap<Integer, Boolean>> stack;
    private HashMap<Integer, Boolean> keyMap;

    public PlayerMovement(int x, int y) {
        position = new Tile(x,y);
        direction = UP;
        stack = new ArrayList<>();
        keyMap = new HashMap<>();
        keyMap.put(UP,false);
        keyMap.put(DOWN,false);
        keyMap.put(LEFT,false);
        keyMap.put(RIGHT,false);
    }

    public Tile getPosition()  { return position; }
    public int  getDirection() { return direction; }


    public void update() {
        if(isDirectionChanged().isPresent()) {
            rotate(UP);
        } else if(keyMap.get(direction)) {
            move();
        }
    }


    public Optional<Integer> isDirectionChanged() {
        for(Map.Entry<Integer, Boolean> e : keyMap.entrySet()) {
            if(Input.getState(e.getKey()) != e.getValue()) {
             return Optional.of(e.getKey());
            }
        }
        return Optional.empty();
    }


    public void move() {
        switch (direction) {
            case UP: position = new Tile(position.x(), position.y() + 1); break;
            case DOWN: position = new Tile(position.x(), position.y() - 1); break;
            case LEFT: position = new Tile(position.x() - 1, position.y()); break;
            case RIGHT: position = new Tile(position.x() + 1, position.y()); break;
        }
    }

    public void rotate(int d) {
        direction = d;
    }
}