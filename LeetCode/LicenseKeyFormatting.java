import java.util.*;

public class LicenseKeyFormatting{

    public String licenseKeyFormatting(String S, int K) {
        Stack<Character> q = new Stack<Character>();
        for(char c: S.toCharArray()) {
            if (c != '-') {
                q.push(c);
            }
        }

        if(q.size() == 0){
            return "";
        }

        int size = q.size() + (q.size() % K == 0 ?  q.size()/K-1 : q.size()/K);
        char[] charArray = new char[size];
        int counter = 0;
        for(int i=size-1; i>=0; i--){
            charArray[i] = q.pop();
            counter++;
            if(counter==K && i != 0){
                i--;
                charArray[i] = '-';
                counter = 0;
            }
        }

        return (new String(charArray)).toUpperCase();
    }

    public static void main(String[] args){
        LicenseKeyFormatting sol = new LicenseKeyFormatting();

        String s = "2-4A0r7-4k";
        int k = 3;

        System.out.println(sol.licenseKeyFormatting(s, k));
    }
}