class ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        int length = words.length;

        if(length == 0){
            return "";
        }
        StringBuilder res = new StringBuilder(words[length-1]);
        for(int i=length-2; i>=0; i--){
            if(words.length > 0){
                res.append(" "+words[i]);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        ReverseWordsInAString sol = new ReverseWordsInAString();

        String input = " a";

        System.out.println(sol.reverseWords(input));
    }
}