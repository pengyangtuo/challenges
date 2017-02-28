import java.util.*;

public class One {
    public static int countStep(int n) {
        int[] previous = new int[n];
        for(int i=0; i<previous.length; i++){
            previous[i] = -1;
        }
        return countStep(n, 1, previous);
    }

    public static int countStep(int n, int offset, int[] previous) {
        while (offset <= n) {
            if (offset == 1) {
                previous[offset - 1] = 1;
            } else if (offset == 2) {
                previous[offset - 1] = 2;
            } else {
                previous[offset - 1] =
                        1 + previous[offset - 2] + previous[offset - 3];
            }
            System.out.println("offset:"+offset);
            System.out.print("previous: ");
            for(int i : previous){
                System.out.print(i + ", ");
            }
            System.out.println();

            offset++;
        }
        return previous[offset - 2];
    }

    public static void main(String[] args){
        int stairs  = 4;

        System.out.println(countStep(stairs));
    }
}