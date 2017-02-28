public class FindTheDuplicateNumber{
    public int findDuplicate(int[] nums) {
        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            while(num != i+1){
                if(nums[i] == nums[num-1]){
                    return nums[i];
                }
                nums[i] = nums[num-1];
                nums[num-1] = num;
                num = nums[i];
            }
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i] != i+1){
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args){
        FindTheDuplicateNumber sol = new FindTheDuplicateNumber();
        int[] input = {1, 2, 3, 5, 6, 7, 7, 7};
        System.out.println(sol.findDuplicate(input));
    }
}