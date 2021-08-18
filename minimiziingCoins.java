import java.util.Arrays;
import java.util.Scanner;

public class minimiziingCoins {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] v = new int[n];

        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
        }
        long[] dp = new long[x + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= x; i++) {
            for (int j : v) {
                if (j <= i && dp[i - j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - j] + 1);
                }
            }
        }
        System.out.println((dp[x] == Integer.MAX_VALUE) ? -1 : dp[x]);
    }

}
