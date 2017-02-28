import java.util.*;
/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }

        int start = 0;
        int end = 0;
        Hashtable<Character, Integer> hash = new Hashtable<Character, Integer>();
        int max = 0;
        while(end < s.length()){
            char letter = s.charAt(end);

            if(hash.get(letter) != null){  // found duplicate
                int prevIdx = hash.get(letter);
//                System.out.println("found duplication ("+letter+") start " + start+"->"+(prevIdx+1));
                int newStart = Math.max(prevIdx+1, start+1);
                while(start != newStart){
                    hash.remove(s.charAt(start));
                    start++;
                }
            }

            hash.put(letter, end);
//            System.out.println("check "+s.substring(start, end+1) + " start "+start+" end "+end);
            if(end - start + 1 > max){
                max = end - start + 1;
            }
            end++;
        }
        return max;
    }

    public static void main(String[] args){
        LongestSubstring sol = new LongestSubstring();

        String input = "tmmzuxt";

        System.out.println(sol.lengthOfLongestSubstring(input));
    }
}