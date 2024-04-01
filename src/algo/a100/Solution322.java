package algo.a100;
class Solution322 {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int MAX = amount + 1;
        // 初始化 dp 表
        int[][] dp = new int[n + 1][amount + 1];
        // 状态转移：首行首列
        for (int a = 1; a <= amount; a++) {
            dp[0][a] = MAX;
        }
        // 状态转移：其余行和列
        for (int i = 1; i <= n; i++) {
            for (int a = 1; a <= amount; a++) {
                if (coins[i - 1] > a) {
                    // 若超过目标金额，则不选硬币 i
                    dp[i][a] = dp[i - 1][a];
                } else {
                    // 不选和选硬币 i 这两种方案的较小值
                    dp[i][a] = Math.min(dp[i - 1][a], dp[i][a - coins[i - 1]] + 1);
                }
            }
        }
        return dp[n][amount] != MAX ? dp[n][amount] : -1;
    }
}