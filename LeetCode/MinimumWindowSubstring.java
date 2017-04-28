public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        int[] map = new int[256];
        for (char i : tChars) {
            map[i]++;
        }

        int start = 0;
        int end = 0;
        int resStart = 0;
        int minWindow = Integer.MAX_VALUE;
        int counter = tChars.length;

        while (end < sChars.length) {
            System.out.println("start="+start+" map["+sChars[start]+"]="+map[sChars[start]]+" end="+end+"["+sChars[end]+"]="+map[sChars[end]]+" counter="+counter);

            if (map[sChars[end++]]-- > 0)        // check if sChars[start] in t or not
                counter--;

            while(counter == 0){

                if(end - start < minWindow) {    // update result
                    resStart = start;
                    minWindow = end - start;
                }

                System.out.println("\tresStart="+resStart+" minWindow="+minWindow);

                if(map[sChars[start++]]++ == 0){    // update count to make the condition fail again
                    counter++;
                }
            }
        }

        return minWindow == Integer.MAX_VALUE ? "" : s.substring(resStart, resStart+minWindow);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring sol = new MinimumWindowSubstring();
        String s = "aa";
        String t = "aa";
        System.out.println(sol.minWindow(s, t));
    }
}