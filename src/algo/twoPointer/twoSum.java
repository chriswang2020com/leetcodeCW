package twoPointer;


class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i<j){
            int sum = numbers[i] + numbers[j];
            if (sum < target){
                i++ ;
            }
            else if (sum > target){
                j-- ;

            }
            else{return new int[]{i + 1, j + 1};}
        }

        return new int[]{-1, -1};
    }
}
public class twoSum {
    public static void main(String[] args) {
        Solution167 solution = new Solution167();
        int[] nums = new int[] {2,3,6,7,9,11,15,};
        int[] result = solution.twoSum(nums, 9);
        System.out.println(result[0] + " " + result[1]);
    }
}
