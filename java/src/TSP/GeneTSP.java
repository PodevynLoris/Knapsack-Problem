package TSP;

public class GeneTSP {

     int x;
     int y;
    static final int MAX_SIZE = 100;

    public GeneTSP(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static int getMAX_SIZE() {
        return MAX_SIZE;
    }

    @Override
    public String toString() {
        return "(" + this.x + ","+this.y + ")";
    }




}
