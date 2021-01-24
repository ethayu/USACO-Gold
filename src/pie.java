import java.util.Scanner;

public class pie {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] input = new int[c][r];
        int[][] dp = new int[c][r];

        for (int i = 0; i < r; i++) {
            dp[0][i] = Integer.MIN_VALUE;
            for (int j = 0; j < c; j++) {
                input[j][i] = sc.nextInt();
            }
        }

        dp[0][0] = input[0][0];

        for (int i = 1; i < c; i++) {
            for (int j = 0; j < r; j++) {
                if (j > i) break;
                if (j != 0 && j != r - 1)
                    dp[i][j] = Integer.max(Integer.max(dp[i - 1][j - 1], dp[i - 1][j]), dp[i - 1][j + 1]) + input[i][j];
                else if (j == 0) dp[i][j] = Integer.max(dp[i - 1][j + 1], dp[i - 1][j]) + input[i][j];
                else dp[i][j] = Integer.max(dp[i - 1][j - 1], dp[i - 1][j]) + input[i][j];
            }
        }

        System.out.println(dp[c - 1][r - 1]);

    }

}
