package algo.a100;

public class generalTest {
    static int ans;

    public static void main(String[] args) {
        Solution128 solution = new Solution128();
        int[] nums = {100, 4, 200, 1, 3, 2};
        // int ans = solution.fakeMethod(nums);
        int ans = solution.longestConsecutive(nums);
        System.out.println(ans);
    }
}