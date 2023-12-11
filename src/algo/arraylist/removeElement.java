package arraylist;

public class removeElement {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
    }
}

class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
}
