import java.util.*;

public class LongestAbsoluteFilePath {

    public int lengthLongestPath(String input) {

        int maxLength = 0;
        int depth = 0;
        Stack<Character> currentPath = new Stack<Character>();

        for(int i=0; i<input.length(); i++){
            char cur = input.charAt(i);

            if(cur == '\n'){
//                System.out.println("-----------------------\nbefore \\n pos="+i);
//                System.out.println("..."+input.charAt(i-3)+input.charAt(i-2)+input.charAt(i-1)+"...");
//                System.out.println(currentPath);

                int newDepth = getDepth(input, i+1);
                if(depth >= newDepth){
                    int depthToRemove = depth-newDepth+1;
                    removeDepth(currentPath, depthToRemove);
                }
                depth = newDepth;
                currentPath.push('/');

//                System.out.println("after \\n pos="+i);
//                System.out.println(currentPath+"\n-----------------------");

                i = i+newDepth;
            }else{
                currentPath.push(cur);
                if(cur == '.'){
                    int newPos = addFile(currentPath, input, i+1);
                    i = newPos-1;
                    maxLength = currentPath.size() > maxLength ? currentPath.size() : maxLength;
//                    System.out.println("mark length");
//                    System.out.println(currentPath);
                }
            }
        }

        return maxLength;
    }

    public void removeDepth(Stack<Character> path, int depth){
        while(!path.empty() && depth != 0){
            char c = path.pop();
            if(c == '/'){
                depth--;
            }
        }
    }

    public int getDepth(String input, int pos){
        int depth = 0;
        for(;pos<input.length();pos++){
            if(input.charAt(pos) == '\t'){
                depth++;
            }else{
                break;
            }
        }
        return depth;
    }

    public int addFile(Stack<Character> path, String input, int pos){
        for(;pos<input.length(); pos++){
            if(input.charAt(pos) == '\n'){
                break;
            }else{
                path.push(input.charAt(pos));
            }
        }
        return pos;
    }

    public static void main(String args[]){
        LongestAbsoluteFilePath sol = new LongestAbsoluteFilePath();

//        String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        String input = "dir\n\tfile.txt";
        System.out.println(sol.lengthLongestPath(input));
    }
}