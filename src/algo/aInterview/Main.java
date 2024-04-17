package algo.aInterview;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();  // 假设只有一个测试案例，输入一个字符串

        int n = input.length();
        int[][] dp = new int[n + 1][n / 3 + 1];  // 最多可能形成 n/3 个 "PDD" 子串
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE / 2);  // 用一个大数初始化，表示无法达到的状态
        }
        dp[0][0] = 0;  // 不修改任何字符且没有 "PDD"

        // 遍历每个可能的起始点来尝试形成 "PDD"
        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= i / 3; j++) {
                if (dp[i][j] < Integer.MAX_VALUE / 2) {
                    // 计算形成 "PDD" 的成本
                    int costP = Math.abs(input.charAt(i) - 'P');
                    int costD1 = Math.abs(input.charAt(i + 1) - 'D');
                    int costD2 = Math.abs(input.charAt(i + 2) - 'D');
                    int totalCost = costP + costD1 + costD2;
                    dp[i + 3][j + 1] = Math.min(dp[i + 3][j + 1], dp[i][j] + totalCost);
                }
            }
        }

        // 找到最大的 j 和相应的最小成本
        int maxScore = 0, minCost = Integer.MAX_VALUE;
        for (int j = 0; j <= n / 3; j++) {
            if (dp[n][j] < Integer.MAX_VALUE / 2) {
                if (2 * j > maxScore) {
                    maxScore = 2 * j;
                    minCost = dp[n][j];
                } else if (2 * j == maxScore) {
                    minCost = Math.min(minCost, dp[n][j]);
                }
            }
        }

        System.out.println("Maximum Score: " + maxScore);
        System.out.println("Minimum Edit Cost: " + minCost);
    }
}
