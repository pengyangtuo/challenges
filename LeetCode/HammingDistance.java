import java.util.*;
public class HammingDistance{
    public int hammingDistance(int x, int y) {
        String res = Integer.toBinaryString(x ^ y);
        int ones = 0;
        for(int i=0; i<res.length(); i++){
            if(res.charAt(i) == '1'){
                ones ++;
            }
        }

        return ones;
    }

    public static void main(String[] args){
        int x = 1;
        int y = 4;

        HammingDistance sol = new HammingDistance();
        System.out.println(sol.hammingDistance(x, y));
    }
}