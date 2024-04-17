package algo.aInterview;

import java.util.Scanner;

public class ali416 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++)
            a[i] = scanner.nextInt();

        int ans = 0;
        int odd = 0, even = 0;
        for (int i = 1; i <= n; i++) {
            if ((a[i] & 1) != 0) {
                ans += odd;
                if (i >= 2 && a[i - 1] % 2 != 0)
                    ans--;
            } else {
                ans += even;
                if (i >= 2 && a[i - 1] % 2 == 0)
                    ans--;
            }
            odd += (a[i] & 1);
            even += (a[i] % 2 == 0) ? 1 : 0;
        }
        System.out.println(ans);
    }
}
