/**
 * https://leetcode.com/problems/count-numbers-with-unique-digits/
 */

import java.util.*;

public class CountNumbersWithUniqueDigits{

    public int countNumbersWithUniqueDigits(int n){

        Hashtable<Integer, Integer> remain = new Hashtable<Integer, Integer>();
        remain.put(0,1);
        remain.put(1,1);
        remain.put(2,1);
        remain.put(3,1);
        remain.put(4,1);
        remain.put(5,1);
        remain.put(6,1);
        remain.put(7,1);
        remain.put(8,1);
        remain.put(9,1);

        return countNumbersWithUniqueDigits(n, remain);

    }

    public int countNumbersWithUniqueDigits(int n, Hashtable<Integer, Integer> remain){
        if(n == 0 || remain.size() == 0){
            return 1;
        }else{
            int res = 0;
            Enumeration<Integer> remainNum = remain.keys();
            while(remainNum.hasMoreElements()){
                int removedNum = remainNum.nextElement();
                if(removedNum == 0 && remain.size() == 10){
                    res += countNumbersWithUniqueDigits(n-1, remain);
                }else{
                    remain.remove(removedNum);
                    res += countNumbersWithUniqueDigits(n-1, remain);
                    remain.put(removedNum, 1);
                }
            }

            return res;
        }
    }

    public static void main(String[] args){
        int n = 3;
        CountNumbersWithUniqueDigits sol = new CountNumbersWithUniqueDigits();

        System.out.println(sol.countNumbersWithUniqueDigits(n));
    }
}