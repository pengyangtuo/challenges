import java.util.*;

public class Six {

    public static String printStack(Stack<Integer> s) {
        StringBuffer res = new StringBuffer();
        Stack<Integer> buffer = new Stack<Integer>();
        while (!s.empty()) {
            Integer disk = s.pop();
            buffer.push(disk);
            while (disk != 0) {
                res.append("-");
                disk--;
            }
            res.append("\n");
        }
        while(!buffer.empty()){
            Integer disk = buffer.pop();
            s.push(disk);
        }
        return res.toString();
    }

    public static void movePile(Stack<Integer> from, Stack<Integer> to, Stack<Integer> through, int n) {
        if (n == 1) {
            moveDisk(from, to);
        } else {
            movePile(from, through, to, n - 1);
            moveDisk(from, to);
            movePile(through, to, from, n - 1);
        }
    }

    public static void moveDisk(Stack<Integer> from, Stack<Integer> to) {
        Integer disk = from.pop();
        to.push(disk);
    }

    public static void main(String[] args) {

        Stack<Integer> from = new Stack<Integer>();
        Stack<Integer> to = new Stack<Integer>();
        Stack<Integer> through = new Stack<Integer>();

        int size = 3;
        from.push(5);
        from.push(4);
        from.push(3);
        from.push(2);
        from.push(1);

        System.out.println("from:\n"+printStack(from)+"*************");
        System.out.println("through:\n"+printStack(through)+"*************");
        System.out.println("to:\n"+printStack(to)+"*************");
        movePile(from, to, through, size);
        System.out.println("from:\n"+printStack(from)+"*************");
        System.out.println("through:\n"+printStack(through)+"*************");
        System.out.println("to:\n"+printStack(to)+"*************");
    }
}