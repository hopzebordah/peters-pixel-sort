package struct;

public class Bounds {

    private int floor;
    private int ceiling;

    public Bounds() {
        this.floor = 0;
        this.ceiling = 0;
    }

    public Bounds(int floor, int ceiling) {
        this.floor = floor;
        this.ceiling = ceiling;
    }

    // copy constructer. i'm not taking any chances
    public Bounds(Bounds other) {
        this.floor = other.floor;
        this.ceiling = other.ceiling;
    }

    // MARK: getters/setters
    public int getFloor() {
        return this.floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getCeiling() {
        return this.ceiling;
    }

    public void setCeiling(int ceiling) {
        this.ceiling = ceiling;
    }

    public void setBounds(int floor, int ceiling) {
        this.floor = floor;
        this.ceiling = ceiling;
    }

    // This method checks if a value fits within the bounds of this object (inclusive)
    public boolean isWithinBounds(int value) {
        if (value < this.floor || value > this.ceiling) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[" + this.floor + " < : > " + this.ceiling + "]";
    }

}