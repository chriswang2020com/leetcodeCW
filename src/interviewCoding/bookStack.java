package org.example.interviewCoding;

import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;

public class bookStack {

    public static Integer books[][] = {{12, 24}, {13, 9}, {2, 5}, {16, 17}, {3, 8}, {13, 22}, {28, 23}};

    public static void main(String[] args) {
        // 按照长和宽的最小值进行排序
        Arrays.sort(books, Comparator.comparingInt(book -> Math.min(book[0], book[1])));

        // 计算最多能放多少本书
        List<Integer[]> result = maxBooks(books);

        System.out.println("Maximum number of books that can be stacked: " + result.size());
        System.out.println("Book stacking order:");
        for (Integer[] book : result) {
            System.out.println(Arrays.toString(book));
        }
    }

    // 计算最多能放多少本书的方法，同时返回具体的排列顺序
    private static List<Integer[]> maxBooks(Integer[][] books) {
        int n = books.length;
        int[] dp = new int[n];
        int[] previousIndex = new int[n]; // 用于记录每本书放置时选择的前一本书的索引
        int maxBooks = 0;
        int lastIndex = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1; // 每本书至少能放一本
            previousIndex[i] = -1; // 初始值设为 -1，表示当前书是放置的第一本

            for (int j = 0; j < i; j++) {
                // 检查当前书是否能够放在之前的书上
                if (Math.min(books[i][0], books[i][1]) > Math.min(books[j][0], books[j][1])) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        previousIndex[i] = j;
                    }
                }
            }

            // 更新最大值和最大值的索引
            if (dp[i] > maxBooks) {
                maxBooks = dp[i];
                lastIndex = i;
            }
        }

        // 根据记录的信息还原书籍的具体排列顺序
        List<Integer[]> result = new ArrayList<>();
        while (lastIndex != -1) {
            result.add(books[lastIndex]);
            lastIndex = previousIndex[lastIndex];
        }

        // 由于记录是从最后一本书开始的，需要将结果翻转
        List<Integer[]> reversedResult = new ArrayList<>();
        for (int i = result.size() - 1; i >= 0; i--) {
            reversedResult.add(result.get(i));
        }

        return reversedResult;
    }
}

