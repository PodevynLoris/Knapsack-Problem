
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

}
