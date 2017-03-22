class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        int length = 0;
        int i = 0;
        while(i < nums.length-1){
            if(nums[i+1] - nums[i] == 1){
                length++;
            }else {
                max = Math.max(max, length);
                length = 0;
            }
            i++;
        }

        return max;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence sol = new LongestConsecutiveSequence();

        int[] input = {100, 4, 200, 1, 3, 2};

        System.out.println(sol.longestConsecutive(input));
    }
}