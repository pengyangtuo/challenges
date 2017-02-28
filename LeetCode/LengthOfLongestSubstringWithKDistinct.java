import java.util.*;

public class LengthOfLongestSubstringWithKDistinct{

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int max = 0;
        int start = 0;
        int distinctNum = 0;
        Hashtable<Character, Integer> distinct = new Hashtable<Character, Integer>();
        int i = 0;

        for(; i<s.length(); i++){
//            System.out.println("hashtable "+distinct.toString());
//            System.out.println("Start:"+start+" end:"+i);


            char cur = s.charAt(i);
            if(!distinct.containsKey(cur)){
                if(distinctNum<k){  // has more space
                    distinct.put(cur, 1);
                    distinctNum++;
                }else{              // no more space
                    distinct.clear();
                    start = updateDistinct(distinct, s, i, k);
                }
            }

            int newLength = i-start+1;
            if(newLength > max){
                max = newLength;
            }
        }

        return max;
    }

    public int updateDistinct(Hashtable<Character, Integer> distinct, String input, int end, int k){
        int i = end;
        int distinctNum = 0;
        while(i >= 0){
            char cur = input.charAt(i);
            if(!distinct.containsKey(cur)){
                if(distinctNum == k){
                    break;
                }

                distinct.put(cur, 1);
                distinctNum++;
            }
            i--;
        }
        return i+1;
    }

    public void printArray(char[] a){
        for(int i=0;i<a.length;i++){
           System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        LengthOfLongestSubstringWithKDistinct sol = new LengthOfLongestSubstringWithKDistinct();

        String s = "ccaabbb";
        int k = 2;
        System.out.println(sol.lengthOfLongestSubstringKDistinct(s, k));
    }
}