import java.util.Scanner;

public class pachinko {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int[][] input = new int[r][r];
        int[][] dp = new int[r][r];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < i + 1; j++) {
                input[i][j] = sc.nextInt();
                if (i == r - 1) dp[i][j] = input[i][j];
            }
        }

        for (int i = r - 2; i >= 0; i--) {
            for (int j = 0; j < i + 1; j++) {
                dp[i][j] = Integer.max(dp[i + 1][j], dp[i + 1][j + 1]) + input[i][j];
            }
        }

        System.out.println(dp[0][0]);

    }

}
