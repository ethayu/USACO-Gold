import java.util.Scanner;

public class hopscotch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        sc.nextInt();

        int[][] grid = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[r][c];
        dp[0][0] = 1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int k = i + 1; k < r; k++) {
                    for (int l = j + 1; l < c; l++) {
                        if (grid[i][j] != grid[k][l]) {
                            dp[k][l] += dp[i][j];
                            dp[k][l] %= 1000000007;
                        }
                    }
                }
            }

        }

        System.out.println(dp[r - 1][c - 1]);
    }
}