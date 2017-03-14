class SingleElementInASortedArray {

    public int singleNonDuplicateHelper(int[] nums, int start, int end){
        int mid = (end - start) / 2;
        System.out.println("start="+start+" end="+end+" mid="+mid);
        if(end - start + 1 == 3){
            return nums[start] == nums[mid] ? nums[end] : nums[start];
        }

        if(nums[mid] == nums[mid-1]){   // single element on the right
            return singleNonDuplicateHelper(nums, mid+1, end);
        }else{                          // on the left
            return singleNonDuplicateHelper(nums, start, mid-1);
        }
    }

    public int singleNonDuplicate(int[] nums) {
        return singleNonDuplicateHelper(nums, 0, nums.length-1);
    }

    public static void main(String[] args) {
        SingleElementInASortedArray sol = new SingleElementInASortedArray();

        int[] input = {3,3,7,7,10,11,11, 12, 12 ,13,13};
//        int[] input = {3,3, 4};
//        int[] input = {2, 3,3};
//        int[] input = {0,1,1,2,2,5,5};
        System.out.println(sol.singleNonDuplicate(input));
    }
}