package main;

public class Tile {

    private int x;
    private int y;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }


    @Override
    public String  toString(){
        return "("+x+","+y+")";
    }

    @Override
    public int hashCode() {
        return x*34 + y*234 %3;
    }

    @Override
    public boolean equals(Object other) {
        if(!(other instanceof Tile)) {
            return false;
        } else {
            return this.x == ((Tile) other).x && this.y == ((Tile) other).y;
        }

    }
}
