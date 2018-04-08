package main;

import java.util.*;

public class PlayerMovement {

    private static final int UP = 8;
    private static final int DOWN = 2;
    private static final int LEFT = 4;
    private static final int RIGHT = 6;
    private static final ArrayList<Integer> precedenceList = new ArrayList<>();
    static {
        precedenceList.add(RIGHT);
        precedenceList.add(LEFT);
        precedenceList.add(DOWN);
        precedenceList.add(UP);
    }

    private int direction;
    private Tile position;
    private ArrayList<Integer> stack;
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
        if(changedDirection().isPresent()) {
            handleEvent(changedDirection().get());
        } else if(keyMap.get(direction)) {
            move();
        }
    }


    public Optional<List<Integer>> changedDirection() {
        ArrayList<Integer> changedDirs = new ArrayList<>();
        for(Map.Entry<Integer, Boolean> e : keyMap.entrySet()) {
            if(Input.getState(e.getKey()) != e.getValue()) {
                changedDirs.add(e.getKey());
            }
        }
        if(changedDirs.size() > 0) {
            return Optional.of(changedDirs);
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

    public void handleEvent(List<Integer> dirs) {
        for(Integer d : precedenceList) {
            if(dirs.contains(d)) {
                if(Input.getState(d)) {
                    stack.add(d);
                    direction = d;
                    keyMap.replace(d, true);
                } else {
                    if(stack.size() > 0 && stack.get(stack.size()-1).equals(d)) {
                        direction = stack.size() > 1 ? stack.get(stack.size()-2) : direction;
                        stack.remove(stack.size()-1);
                    } else {
                        stack.remove(new Integer(d));
                        move();
                    }
                    keyMap.replace(d, false);
                }
            }
        }
    }
}