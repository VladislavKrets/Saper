package model;

/**
 * Created by lollipop on 03.09.2016.
 */
public class Cell {
    private boolean isBomb = false;
    private int bombsNumber = 0;
    public boolean isBomb() {
        return isBomb;
    }

    public void setBomb(boolean bomb) {
        isBomb = bomb;
    }

    public int getBombsNumber() {
        return bombsNumber;
    }

    public void setBombsNumber(int bombsNumber) {
        this.bombsNumber = bombsNumber;
    }

    public String toString() {
        return isBomb() ? "*" : "" + bombsNumber;
    }
}
