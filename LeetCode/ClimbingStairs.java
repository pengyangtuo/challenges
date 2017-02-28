import java.util.*;

public class ClimbingStairs {
    public int climbStairs(int n) {
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return climb(n, memo);
    }

    public int climb(int n, int[] memo){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            memo[n-1] = 1;
            return 1;
        }
        if(n == 2){
            memo[n-1] = 2;
            return 2;
        }

        if(memo[n-1] != -1){
            return memo[n-1];
        }

        int res = climb(n-1, memo) + climb(n-2, memo);
        memo[n-1] = res;

        return res;
    }

    public static void main(String[] args){
        ClimbingStairs sol = new ClimbingStairs();

        int input = 5;
        System.out.println(sol.climbStairs(input));
    }
}