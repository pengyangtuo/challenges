class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        memo[0][0] = 1;
        uniquePathsHelper(1, 0, memo[0][0], memo);
        uniquePathsHelper(0, 1, memo[0][0], memo);

        return memo[m-1][n-1];
    }

    public void uniquePathsHelper(int m, int n, int previous, int[][] memo) {
        if(m > memo.length-1 || n > memo[0].length-1){
            return;
        }

//        System.out.println("---------------");
//        System.out.println("at "+m+","+n+" ("+memo[m][n]+") add " + previous);
        memo[m][n] += 1;

        uniquePathsHelper(m+1, n, memo[m][n], memo);
        uniquePathsHelper(m, n+1, memo[m][n], memo);
    }

    public static void main(String[] args) {
        UniquePaths sol = new UniquePaths();
        System.out.println(sol.uniquePaths(3, 3));
    }
}