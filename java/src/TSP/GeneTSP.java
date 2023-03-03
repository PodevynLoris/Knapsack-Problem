package TSP;

public class GeneTSP {

    final int x;
    final int y;
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
    public static int getMAX_SIZE() {
        return MAX_SIZE;
    }

    @Override
    public String toString() {
        return "(" + this.x + ","+this.y + ")";
    }




}
