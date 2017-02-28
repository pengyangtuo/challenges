import java.util.*;

public class NQueens{

    private class Pos{
        public int i;
        public int j;
        public Pos(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        LinkedList<Pos> current = new LinkedList<Pos>();

        solveNQueensHelper(current, res, 0, n);

        return res;
    }

    public ArrayList<String> createStringSol(LinkedList<Pos> sol, int n){
        ArrayList<String> res = new ArrayList<String>();

        for(int i=0; i<sol.size(); i++){

            char[] pattern = new char[n];
            Arrays.fill(pattern, '.');
            pattern[sol.get(i).j] = 'Q';
            res.add(new String(pattern));
        }

        return res;
    }

    public void solveNQueensHelper(LinkedList<Pos> current, List<List<String>> res, int row, int n){
        if(row >= n){
            return;
        }

        for(int col=0; col<n; col++){

            Pos currentPos = new Pos(row, col);

            if(isValid(currentPos, current)){
                current.addLast(currentPos);
                if(row == n-1){ // found solution
                    res.add(createStringSol(current, n));
                }else{
                    solveNQueensHelper(current, res, row+1, n);
                }
                current.removeLast();
            }
        }
        return;
    }

    public boolean isValid(Pos pos, LinkedList<Pos> poses){
        for(int i=0; i<poses.size(); i++){
            Pos posPrime = poses.get(i);

            if(posPrime.j == pos.j
                    || Math.abs(posPrime.i-pos.i) == Math.abs(posPrime.j-pos.j)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        NQueens sol = new NQueens();
        List<List<String>> res = sol.solveNQueens(4);
        System.out.println(res);

    }
}