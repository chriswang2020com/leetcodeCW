package algo.aInterview;
import java.util.*;
public class topK {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] ans = Solution.topKFrequent(nums, k);
        for (int i: ans){
            System.out.println(i);
        }
    }
}


class Solution {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // 统计数量
        for (int num : nums){
            if (map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }
            else{map.put(num, 1);}
        }
        //桶排序
        List<Integer>[] buckets = new List[nums.length + 1];
        for(int key : map.keySet()){
            // 获取出现的次数作为下标
            int frequency = map.get(key);
            if(buckets[frequency] == null){
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }

        // 倒序遍历桶
        int[] res = new int[k];
        int index = 0;
        for(int i = buckets.length - 1; i >= 0 && index < k; i--){
            if(buckets[i] == null) continue;
            for(int num : buckets[i]){
                res[index++] = num;
                if(index == k) return res;
            }
        }
        return res;
    }
}
