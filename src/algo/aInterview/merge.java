package algo.aInterview;

public class merge {



    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        Solution1.merge(nums1,m, nums2,n);
        for (int i: nums1){
            System.out.println(i);
        }
    }
}


class Solution1 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1, p = m + n - 1;
        while (p2 >= 0) { // nums2 还有要合并的元素
            // 如果 p1 < 0，那么走 else 分支，把 nums2 合并到 nums1 中
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p--] = nums1[p1--]; // 填入 nums1[p1]
            } else {
                nums1[p--] = nums2[p2--]; // 填入 nums2[p1]
            }
        }
    }
}