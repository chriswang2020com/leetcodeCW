package algo.a100;

import java.util.HashSet;
import java.util.Set;

class Solution128 {
    public int fakeMethod(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++){

            int cur = nums[i] + 1;
            while (true){
                boolean flag = false;
                for (int j = 0; j < n; j++){
                    if (nums[j] == cur){
                        flag = true;
                        break; // 找到就跑路，去找下一个
                    }
                }
                cur ++;
                if (!flag){
                    break; // 找不到的话退出
                }

            }
            ans = Math.max(ans, cur - nums[i]);
        }
        return ans;
    }

    public int longestConsecutive(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (Integer num : nums) {
            set.add(num);
        }
        int ans = 0;
        for (Integer num : set) {
            int cur = num;
            // 剪枝 只有当num-1不存在时，才开始向后遍历num+1，num+2，num+3......
            if (!set.contains(cur - 1)){
                while (set.contains(cur+1)){
                    cur++;
                }
            }
            ans = Math.max(ans, cur - num + 1);
        }
        return ans;
    }
}