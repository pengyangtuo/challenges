import java.util.*;

public class Nine {

    public static ArrayList<String> printParens(int n){
        return printParens("", n, n);
    }

    public static ArrayList<String> printParens(String s, int left, int right) {
        ArrayList<String> res = new ArrayList<String>();

        if(left > 0){
            res.addAll(printParens(s+"(", left-1, right));
        }
        if(left < right && right > 0) {
            res.addAll(printParens(s+")", left, right-1));
        }

        if(left == 0 && right == 0){
            res.add(s);
        }

        return res;
    }

    public static void main(String[] args) {

        int n = 4;
        ArrayList<String> res = printParens(n);
        for(String p : res){
            System.out.println(p);
        }
    }
}