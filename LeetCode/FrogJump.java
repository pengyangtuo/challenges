class FrogJump {
    public void memoString(int[][] memo, int[] stones){
        int size = stones.length;
        System.out.println();
        for(int i=0;i<size; i++){
            System.out.print(stones[i]+" | ");
            for (int j=0;j<size; j++){
                System.out.print(memo[i][j] + " ");
            }
            System.out.println();
        }
    }
    public boolean canCross(int[] stones) {
        int size = stones.length;
        if(size < 2){
            return true;
        }
        if(stones[1] - stones[0] > 1){
            return false;
        }
        int memo[][] = new int[size][size];
        int i;
        int j;
        int k;
        memo[0][1] = 1;

        for(i=1; i<stones.length-1; i++){
            for(int ki=0; ki<i+1; ki++){
                k = memo[ki][i+1-1];
                if(k == 0){
                    continue;
                }
                for(j=i+1; j<stones.length; j++){
                    int newK = stones[j] - stones[i];
                    if(Math.abs(newK - k) <= 1){
                        memo[i][j] = newK;
                    }
                }
            }
        }

        memoString(memo, stones);

        for (i=0; i<stones.length; i++){
            if (memo[i][size-1] > 0){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        FrogJump sol = new FrogJump();

//        int[] input = {0,1,3,5,6,8,12,17};
        int[] input = {0,1,2,3,4,8,9,11};
//        int[] input = {0,1,3,6,10,15,16,21};

        System.out.println(sol.canCross(input));
    }
}