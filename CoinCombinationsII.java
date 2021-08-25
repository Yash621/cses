import java.util.Scanner;

public class CoinCombinationsII {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] v = new int[n];

        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
        }

        long[][] dp = new long[n][x + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= x; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                    continue;
                }

                if (i == 0) {

                    if (j - v[i] < 0) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i][j - v[i]];
                    }

                } else {

                    if (i == 0 && j - v[i] < 0) {
                        dp[i][j] = 0;
                    } else if (j - v[i] < 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - v[i]];
                    }

                }

            }
        }

        System.out.println(dp[n - 1][x]);
    }

}
