import java.util.Scanner;

public class DiceCombinations {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int r = 6;
            if (i < 6) {
                r = (i);
            }
            for (int j = 1; j <= r; j++) {

                dp[i] += dp[i - j];
            }
        }
        System.out.println((long) ((dp[n]) % (Math.pow(10, 9) + 7)));
    }

}
