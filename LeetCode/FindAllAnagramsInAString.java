import java.util.*;

public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();

        int[] map = new int[256];
        for (char i : pChars) {
            map[i]++;
        }

        int counter = pChars.length;
        int start = 0;
        int end = 0;

        ArrayList<Integer> res = new ArrayList<>();

        while (end < sChars.length) {
//            System.out.println("start="+start+"["+sChars[start]+"] end="+end+"["+sChars[end]+"] counter="+counter);
            if (map[sChars[end++]]-- > 0) {
                counter--;
            }

            while (end - start == pChars.length) {
//                System.out.println("\tstart="+start+" end="+end+" counter="+counter);
                if (counter == 0) {
                    res.add(start);
                }
                if (map[sChars[start++]]++ >= 0) {
                    counter++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        FindAllAnagramsInAString sol = new FindAllAnagramsInAString();
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(sol.findAnagrams(s, p));
    }
}