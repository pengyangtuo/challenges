/**
 * https://leetcode.com/problems/regular-expression-matching/
 */

import java.util.*;

public class REMatching {
    public void printRes(boolean[][] res, String s, String p){
        System.out.print("      ");
        for(int i=0; i<p.length(); i++){
            System.out.print(p.charAt(i)+" ");
        }
        System.out.println();
        System.out.print("    ");
        for(int i=0; i<res[0].length; i++){
            System.out.print(i+" ");
        }
        System.out.println();
        for(int i=0; i<res.length; i++){
            char prefix = i==0 ? ' ' : s.charAt(i-1);
            System.out.print(prefix+" "+i+" ");

            for(int j=0; j<res[i].length; j++){
                if(res[i][j]){
                    System.out.print("T ");
                }else{
                    System.out.print("F ");
                }
            }
            System.out.println();
        }
    }

    public boolean isMatch(String s, String p) {
        boolean[][] res = new boolean[s.length()+1][p.length()+1];
        res[0][0] = true;

        for(int i=0; i<p.length(); i++){
            if(p.charAt(i)=='*'){
                res[0][i+1] = res[0][i-1];
            }
        }

        for(int i=0; i<s.length(); i++){
            for(int j=0; j<p.length(); j++){
                if(p.charAt(j) == s.charAt(i)
                        || p.charAt(j) == '.'){
                    res[i+1][j+1] = res[i][j];
                }
                if(p.charAt(j) == '*'){
                    if(p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.'){
                        res[i+1][j+1] = res[i+1][j-1];
                    }else{
                        res[i+1][j+1] =
                                res[i+1][j-1] || // count as zero
                                res[i+1][j]     || // count as one
                                res[i][j+1];     // multiple
                    }

                }
            }
        }
//        printRes(res, s, p);

        return res[s.length()][p.length()];
    }

    public static void main(String[] args){
        REMatching sol = new REMatching();
        String s = "abcabc";
        String p = ".*";
        System.out.println(sol.isMatch(s, p));
    }
}