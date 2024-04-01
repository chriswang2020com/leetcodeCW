package algo.a100;


import java.util.*;

class Solution47 {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<Integer>();
    private HashMap<Integer, Boolean> mark = new HashMap<Integer, Boolean>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        for (int num : nums){
            mark.put(num, false);
        }
        if (nums.length == 0) return ans;

        dfs(nums, 0);
        return ans;
    }
    private void dfs(int[] nums, int index){
        if (index == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (mark.get(i)){
                continue;
            }
            path.add(nums[i]);
            mark.put(nums[i], true);
            dfs(nums, index + 1);
            mark.put(nums[i], false);
            path.remove(path.size() - 1);
        }
    }
}