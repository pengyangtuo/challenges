public class SlidingWindowMaximum {

    public int max(int[] nums, int start, int end){
        int max = Integer.MIN_VALUE;
        for(int i=start; i<=end; i++){
            if(nums[i] > max) max = nums[i];
        }
        return max;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0){
            return new int[0];
        }
        int[] res = new int[nums.length-k+1];
        int start = 0;
        int end = 0;

        while(end < nums.length) {
            int cur = nums[end];

            while(end - start + 1 == k) {
                res[start] = max(nums, start, end);
                start++;
            }
            end++;
        }

        return res;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum sol = new SlidingWindowMaximum();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        int[] res = sol.maxSlidingWindow(nums, k);

        for(int i=0; i<nums.length-k+1; i++){
            System.out.print(res[i] + " ");
        }
    }
}