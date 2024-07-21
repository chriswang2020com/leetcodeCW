package algo.a100;

import java.util.Scanner;


/**
 * @Test [3,5,2,4,1,6] answer: 5
 * @Description: 121. 买卖股票的最佳时机
 */
public class Solution121DP {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a list of integers separated by commas:");
            String input = scanner.nextLine();
            method1(input);

        }

        public static void method1(String input) {
            String[] stringNumbers = input.replaceAll("[\\[\\]]", "").split(",");
            Integer[] prices = new Integer[stringNumbers.length];
            for (int i = 0; i < stringNumbers.length; i++) {
                prices[i] = Integer.parseInt(stringNumbers[i]);
            }
            int[][] dp = new int[prices.length][2];
            dp[0][0] = 0;
            dp[0][1] = - prices[0];
            for (int i = 1; i < prices.length; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            }
            System.out.println(dp[prices.length - 1][0]);
        }

}
