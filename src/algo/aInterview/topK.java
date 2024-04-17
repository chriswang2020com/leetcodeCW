package algo.aInterview;
import java.util.*;
public class topK {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3,4,766,1,2,3,5,1,7,7,56,7,7,7,7,7,7,7};
        int k = 2;
        Solution s = new Solution();
        int[] ans = s.topKFrequent1(nums, k);
        Queue<Integer> topk = s.topK(nums,k);
        for (Integer element: topk){
            System.out.println(element);
        }

        System.out.println(Arrays.toString(ans));
    }
}


class Solution {
    public Queue<Integer> topK(int[] nums, int k){
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < k; i++){
            minHeap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++){
            if (nums[i] > minHeap.peek()){
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap;
    }
    public int[] topKFrequent(int[] nums, int k) {
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

    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            if (map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }
            else {
                map.put(num, 1);
            }
        }
        Queue<Integer> queue = new PriorityQueue<>((o1,o2) -> map.get(o1) - map.get(o2));
        for (Integer key: map.keySet()){
            if (queue.size() < k){
                queue.offer(key);
            }
            else if (map.get(key) > map.get(queue.peek())){
                queue.poll();
                queue.offer(key);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k ; i++){
            res[i] = queue.poll();
        }
        return res;
    }
}
