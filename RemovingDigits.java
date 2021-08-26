import java.util.Arrays;
import java.util.Scanner;

public class RemovingDigits {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String x = Integer.toString(n);

        int nd = x.length();

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int j = 1; j < n + 1; j++) {
            x = Integer.toString(j);
            for (int k = 0; k < x.length(); k++) {
                String s = x.substring(k, k + 1);
                int no = Integer.parseInt(s);
                if (j >= no) {
                    dp[j] = Math.min(dp[j], dp[j - no] + 1);
                }
            }
        }
        System.out.println(dp[n]);
    }

}
