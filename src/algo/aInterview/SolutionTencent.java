package algo.aInterview;

import java.util.ArrayList;

// 思路：把出现过的数字，通过负号标记到对应的index上。
// 如果下标为负，说明出现过
public class SolutionTencent {
    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,1,2,4};
        System.out.println(findDup(input));

    }
    private static ArrayList<Integer> findDup(int[] input){
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < input.length; i++){
            int index = Math.abs(input[i]);
            if (input[index - 1] < 0){
                ans.add(index);
            }
            else{
                input[index - 1] *= -1;
            }
        }

        return ans;
    }
}
