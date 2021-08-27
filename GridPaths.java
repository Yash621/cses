import java.util.Arrays;
import java.util.Scanner;
import java.math.BigInteger;

public class GridPaths {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            String x = sc.next();
            s[i] = x;
        }

        String[][] dp = new String[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], "");
        }

        dp[n - 1][n - 1] = (s[n - 1].charAt(n - 1) == '*') ? "0" : "1";

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                if (i == n - 1 && j == n - 1) {
                    continue;
                }

                if (s[i].charAt(j) != '*') {
                    if (i + 1 > n - 1) {
                        dp[i][j] = dp[i][j + 1];
                    } else if (j + 1 > n - 1) {
                        dp[i][j] = dp[i + 1][j];
                    } else {
                        dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                    }
                }
            }
        }

        BigInteger f = new BigInteger("0");

        for (int i = 0; i < dp[0][0].length(); i++) {

            BigInteger v = new BigInteger(dp[0][0].substring(i, i + 1));

            f = f.add(v);

        }
        String c = Integer.toString(1000000007);

        System.out.println(f.mod(new BigInteger(c)));
    }
}
