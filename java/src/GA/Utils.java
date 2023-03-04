package GA;

import TSP.GeneTSP;

public class Utils {

    public static int flip(int value) {
        if (value==0) {
            return 1;
        } else if (value==1) {
            return 0;
        } else {
            throw new IllegalArgumentException("Not binary input");
        }
    }

    public static double euclideanDistance(GeneTSP a, GeneTSP b) {
        double dist;
        double deltaX = Math.pow(a.getX()-b.getX(),2);
        double deltaY = Math.pow(a.getY()-b.getY(),2);
        dist = Math.sqrt(deltaX+deltaY);
        return dist;
    }

}
