import java.util.Arrays;
import java.util.Scanner;

public class CoinCombinationsI {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] v = new int[n];

        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
        }
        long[] dp = new long[x + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for (int i = 1; i <= x; i++) {
            for (int j : v) {
                if (j <= i && dp[i - j] != 0) {
                    dp[i] += dp[i - j];
                }
            }
        }
        System.out.println(dp[x] % (Math.pow(10, 9) + 7));

    }

}
