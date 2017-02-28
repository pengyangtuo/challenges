import java.util.*;

public class Eight {

    public static ArrayList<String> getPerm(String s) {
        ArrayList<String> res = new ArrayList<String>();
        if(s.length() == 0) {
            return res;
        }

        String prefix = s.substring(0, 1);
        if(s.length() == 1) {
            res.add(s);
            return res;
        }

        ArrayList<String> subStrPerm =
                getPerm(s.substring(1,s.length()));

        for(String ss : subStrPerm) {
            for(int i=0; i<=ss.length(); i++) {
                if(i > 0 && ss.substring(i-1, i).equals(prefix)){
                    continue;
                }
                String p = insertCharAt(ss, prefix, i);
                res.add(p);
            }
        }

        return res;
    }

    public static String insertCharAt(String s, String i, int idx){
        if(idx == s.length()){
            return s+i;
        }
        String firstHalf = s.substring(0,idx);
        String secondHalf = s.substring(idx, s.length());
        return firstHalf + i + secondHalf;
    }

    public static void main(String[] args) {
        String s = "abccc";

        ArrayList<String> res = getPerm(s);

        int liner = s.length();
        int linerCount = 0;
        for(String r : res){
            System.out.print(r + " ");
            linerCount++;
            if(linerCount == liner){
                System.out.println();
                linerCount = 0;
            }
        }
    }
}