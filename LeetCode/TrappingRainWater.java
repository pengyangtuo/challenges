class TrappingRainWater {
    public int trap(int[] height) {
        if(height.length < 3){
            return 0;
        }

        int[] leftMaxs = new int[height.length];
        int[] rightMaxs = new int[height.length];
        int res = 0;

        // get left max
        int leftMax = 0;
        leftMaxs[0] = leftMax;
        for(int i=1;i<height.length;i++){
            if(leftMax < height[i-1]){
                leftMax = height[i-1];
            }
            leftMaxs[i] = leftMax;
        }
        // get right max
        int rightMax = 0;
        rightMaxs[height.length-1] = rightMax;
        for(int i=height.length-2;i>=0;i--){
            if(rightMax < height[i+1]){
                rightMax = height[i+1];
            }
            rightMaxs[i] = rightMax;
        }

        for(int i=0;i<height.length;i++){
            int water = Math.min(leftMaxs[i], rightMaxs[i]) - height[i];
            res += water >= 0 ? water : 0;
        }

        return res;
    }

    public static void main(String[] args) {
        TrappingRainWater sol = new TrappingRainWater();

        int[] input = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        System.out.println(sol.trap(input));
    }
}