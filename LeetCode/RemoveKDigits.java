public class RemoveKDigits{
    public String removeKdigits(String num, int k) {

        if(num.length() == k){
            return "0";
        }

        // remove leading zeros
        int n;
        for(n=0; n<num.length(); n++){
            if(num.charAt(n) != '0'){
                break;
            }
        }
        num = num.substring(n, num.length());
        if(num.length() == 0){
            return "0";
        }

        int kk = k;
        for(n=0; n<num.length(); n++){

            if(num.charAt(n) == '0'){
                return removeKdigits(num.substring(n, num.length()), kk);
            }

            kk--;

            if(kk < 0){
                break;
            }
        }

        int length = num.length();
        char[] res = new char[length - k];

        int start = 0;
        int end = 1;
        for(int i=0; i<res.length; i++){
            while(end<num.length() && num.charAt(start)>num.charAt(end)){
                if(num.length() - (start+1) == res.length-(i+1)){
                    for(int j=start; j<num.length(); j++){
                        res[i] = num.charAt(j);
                        i++;
                    }
                    return new String(res);
                }
                start++;
                end++;
            }
            res[i] = num.charAt(start);
            start++;
            end++;
        }
        return new String(res);
    }

    public static void main(String[] args){
        RemoveKDigits sol = new RemoveKDigits();

        String num = "10";
        int k = 1;
        System.out.println(sol.removeKdigits(num, k));
    }
}