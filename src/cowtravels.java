import java.util.Scanner;

public class cowtravels {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int t = sc.nextInt();
        int[][] grid = new int[r][c];
        for (int i = 0; i < r; i++) {
            String row = sc.next();
            for (int j = 0; j < c; j++) {
                if (row.charAt(j) == '*') grid[i][j] = 1;
            }
        }

        int a = sc.nextInt();
        int b = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        int[][][] dp = new int[r][c][t + 1];

        dp[a - 1][b - 1][0] = 1;

        for (int i = 0; i < t; i++) {
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    if (dp[j][k][i] != 0) {
                        for (int l = 0; l < 4; l++) {
                            if (j + dx[l] >= 0 && j + dx[l] < r && k + dy[l] > 0 && k + dy[l] < c)
                                if (grid[j + dx[l]][k + dy[l]] != 1) dp[j + dx[l]][k + dy[l]][i + 1] += dp[j][k][i];
                        }
                    }
                }
            }
        }

        System.out.println(dp[x - 1][y - 1][t]);

    }

}
