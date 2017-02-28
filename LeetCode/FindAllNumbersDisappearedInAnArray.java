//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
import java.util.*;

public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        for(int i=0; i<nums.length; i++){
            int cur = nums[i];
            int curIdx = cur-1;
            while(cur != nums[curIdx]){
                int temp = nums[curIdx];
                nums[curIdx] = cur;
                cur = temp;
                curIdx = cur-1;
            }
        }
        for(int j=0; j<nums.length; j++){
            if(nums[j] != j+1){
                res.add(j+1);
            }
        }
        return res;
    }

    public static void main(String[] args){
        FindAllNumbersDisappearedInAnArray sol = new FindAllNumbersDisappearedInAnArray();
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(sol.findDisappearedNumbers(nums));
    }
}