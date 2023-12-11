package twoPointer;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int size = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k){


                int sum = nums[k] + nums[i] + nums[j];
                if(sum < 0){
                    while(j < k && nums[j] == nums[++j]);
                } else if (sum > 0) {
                    while(j < k && nums[k] == nums[--k]);
                } else {

                    res.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[k])));
                    while(j < k && nums[j] == nums[++j]);
                    while(j < k && nums[k] == nums[--k]);


                }
            }
        }
        return res;

    }
}
public class threeSum {
    public static void main(String[] args) {
        Solution15 solution = new Solution15();
        int[] nums = new int[] {-1,0,1,2,-1,-4};
        List<List<Integer>> result = solution.threeSum(nums);
        System.out.println(result);
    }
}
