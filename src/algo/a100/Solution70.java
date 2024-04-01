package algo.a100;

import java.util.*;

class Solution70 {
    public int climbStairs(int n) {
        int[] mem = new int[n + 1];
        Arrays.fill(mem, -1);
        return dfs(n, mem);
    }

    private int dfs(int i, int[] mem) {
        if (i == 1 || i == 2){
            return 1;
        }
        if (mem[i] != -1){
            return mem[i];
        }
        int count = dfs(i - 1, mem) + dfs(i-2, mem);
        mem[i] = count;
        return count;
    }
}

class Solution70a {
    public int climbStairs(int n) {
        if (n == 1 || n == 2)
            return n;
        // 初始化 dp 表，用于存储子问题的解
        int[] dp = new int[n + 1];
        // 初始状态：预设最小子问题的解
        dp[1] = 1;
        dp[2] = 2;
        // 状态转移：从较小子问题逐步求解较大子问题
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}