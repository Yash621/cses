import java.util.Arrays;
import java.util.Scanner;

public class BookShop {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] p = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < 2 * n; i++) {
            if (i < n) {
                p[i] = sc.nextInt();
            } else {
                b[i - n] = sc.nextInt();
            }
        }

        int[][] dp = new int[n][x + 1];

        for (int k = 0; k < n; k++) {
            for (int i = 1; i <= x; i++) {

                if (k == 0) {
                    dp[k][i] = (i >= p[k]) ? b[k] : 0;
                } else {

                    if (i >= p[k]) {
                        dp[k][i] = Math.max(dp[k - 1][i], dp[k - 1][i - p[k]] + b[k]);
                    } else {
                        dp[k][i] = dp[k - 1][i];
                    }
                }

            }
        }

        System.out.println(dp[n - 1][x]);

    }

}
