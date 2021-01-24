import java.util.Scanner;

public class subset {

    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = n * (n + 1) / 4;

        long[][] dp = new long[n + 1][sum + 1];

        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] += dp[i - 1][j];
                if (j - i >= 0) dp[i][j] += dp[i - 1][j - i];
            }
        }

        System.out.println((n * (n + 1) / 2) % 2 == 1 ? 0 : dp[n][sum] / 2);

    }

}
