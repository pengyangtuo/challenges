class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int height = obstacleGrid.length;
        int width = obstacleGrid[0].length;

        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if(obstacleGrid[i][j] == 1){
                    obstacleGrid[i][j] = -1;
                }
            }
        }

        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                int res;
                if (obstacleGrid[i][j] < 0) {
                    res = 0;
                } else if(i == 0 && j == 0){
                    res = 1;
                } else {
                    int left;
                    int top;
                    if(i == 0){
                        top = 0;
                    }else {
                        top = obstacleGrid[i-1][j] < 0 ? 0 : obstacleGrid[i-1][j];
                    }

                    if(j == 0){
                        left = 0;
                    }else{
                        left = obstacleGrid[i][j-1] < 0 ? 0 : obstacleGrid[i][j-1];
                    }

                    res = left + top;
                }

                obstacleGrid[i][j] = res;
            }
        }

        return obstacleGrid[height-1][width-1];
    }

    public static void main(String[] args) {
        UniquePathsII sol = new UniquePathsII();

        int[][] input = {{0, 0}};
        System.out.println(sol.uniquePathsWithObstacles(input));
    }
}