import java.util.*;

public class FindAllDuplicatesInAnArray{
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        for(int n : nums){
            n = n < 0 ? -n : n;
            int pos = n - 1;
            if(nums[pos] < 0){
                res.add(n);
            }else{
                nums[pos] = -nums[pos];
            }
        }
        return res;
    }

    public static void main(String[] args){
        FindAllDuplicatesInAnArray sol = new FindAllDuplicatesInAnArray();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(sol.findDuplicates(nums));
    }
}