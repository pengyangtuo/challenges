import java.util.*;

public class SurroundedRegions{

    private class Pos{
        public int i;
        public int j;
        public Pos(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    public void solve(char[][] board) {

        if(board.length == 0 || board[0].length ==0){
            return;
        }
        int width = board[0].length;
        int height = board.length;
        LinkedList<Pos> queue = new LinkedList<Pos>();

        // first scan and mark not surrounded
        for(int col=0; col<width; col++){

            // first row
            if(board[0][col] == 'O'){
                queue.add(new Pos(0, col));
                while(queue.size() != 0){
                    Pos pos = queue.removeFirst();
                    markFalse(board, pos, width, height, queue);
                }
            }
            // last row
            if(board[height-1][col] == 'O'){
                queue.add(new Pos(height-1, col));
                while(queue.size() != 0){
                    Pos pos = queue.removeFirst();
                    markFalse(board, pos, width, height, queue);
                }
            }
        }

        for(int row=0; row<height; row++){
            if(board[row][0] == 'O'){
                queue.add(new Pos(row, 0));
                while(queue.size() != 0){
                    Pos pos = queue.removeFirst();
                    markFalse(board, pos, width, height, queue);
                }
            }
            if(board[row][width-1] == 'O'){
                queue.add(new Pos(row, width-1));
                while(queue.size() != 0){
                    Pos pos = queue.removeFirst();
                    markFalse(board, pos, width, height, queue);
                }
            }
        }

        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == '-'){
                    board[i][j] = 'O';
                }
            }
        }

        return;
    }

    public void markFalse(char[][] board, Pos pos, int width, int height, LinkedList<Pos> queue){
        int i = pos.i;
        int j = pos.j;
        if(i<0 || i>=height || j<0 || j>=width || board[i][j] == '-' || board[i][j] == 'X'){
            return;
        }
        board[i][j] = '-';
        if(i-1>=0 && i-1<height && j>=0 && j<width && board[i-1][j] == 'O'){
            queue.add(new Pos(i-1, j));
        }
        if(i+1>=0 && i+1<height && j>=0 && j<width && board[i+1][j] == 'O'){
            queue.add(new Pos(i+1, j));
        }
        if(i>=0 && i<height && j-1>=0 && j-1<width && board[i][j-1] == 'O'){
            queue.add(new Pos(i, j-1));
        }
        if(i>=0 && i<height && j+1>=0 && j+1<width && board[i][j+1] == 'O'){
            queue.add(new Pos(i, j+1));
        }

        return;
    }

    public static void main(String[] args){
        char[][] input = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        SurroundedRegions sol = new SurroundedRegions();

        for(char[] cs: input){
            for(char c: cs){
                System.out.print(c+" ");
            }
            System.out.println();
        }

        System.out.println("--------------------");
        sol.solve(input);
        for(char[] cs: input){
            for(char c: cs){
                System.out.print(c+" ");
            }
            System.out.println();
        }
    }
}