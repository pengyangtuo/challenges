import java.util.*;

class ValidParentheses {

    private static char[] MAP = new char[128];

    static {
        MAP[')'] = '(';
        MAP[']'] = '[';
        MAP['}'] = '{';
    }


    public static boolean isValid(String input) {
        Stack<Character> stack = new Stack<Character>();

        char[] parentheses = input.toCharArray();

        for (int i = 0; i < parentheses.length; i++) {
            char cur = parentheses[i];
            if (stack.isEmpty() || cur == '(' || cur == '{' || cur == '[') {
                stack.push(cur);
            } else {
                if(stack.peek() == MAP[cur]) {
                    stack.pop();
                }else{
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {

        String input = "([)]";
        System.out.println(ValidParentheses.isValid(input));
    }
}