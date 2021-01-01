import java.util.Scanner;

public class checklist {

    static class cow {
        int x, y;

        cow(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int dist(cow cow) {
            return (this.x - cow.x) * (this.x - cow.x) + (this.y - cow.y) * (this.y - cow.y);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        cow[] ns = new cow[n];
        cow[] ms = new cow[m];

        int[][][] dp = new int[n + 1][m + 1][2];

        for (int i = 0; i < n; i++) {
            ns[i] = new cow(sc.nextInt(), sc.nextInt());
        }

        for (int i = 0; i < m; i++) {
            ms[i] = new cow(sc.nextInt(), sc.nextInt());
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j][0] = Integer.MAX_VALUE;
                dp[i][j][1] = Integer.MAX_VALUE;
            }
        }

        System.out.println(dp[0].length);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                for (int k = 0; k < 2; k++) {
                    if (k == 0 && i == 0) continue;
                    if (k == 1 && j == 0) continue;
                    if (i < n)
                        try {
                            if (k == 1) {
                                dp[i + 1][j][k] = Math.min(dp[i][j][k] + ns[i].dist(ns[i + 1]), dp[i + 1][j][k]);
                                dp[i + 1][j][k] = Math.min(dp[i][j][k] + ns[i].dist(ns[i + 1]), dp[i + 1][j][k]);
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.printf("error is :%s%n", e);
                        }
                    if (j < m)
                        try {
                            if (k == 0)
                                dp[i][j + 1][k] = Math.min(dp[i][j][k] + ns[j].dist(ms[j + 1]), dp[i][j + 1][k]);
                            else dp[i][j + 1][k] = Math.min(dp[i][j][k] + ms[j].dist(ms[j + 1]), dp[i][j + 1][k]);
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println(e);
                        }

                }
            }
        }

        System.out.println(dp[n][m][0]);

    }

}
