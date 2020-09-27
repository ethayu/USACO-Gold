import java.util.Scanner;

public class fliptile {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int[][] ans = new int[n][m];
        int flips = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int[][] currgrid = grid.clone();
            int[][] potans = new int[n][m];
            if (i == 0) {

            } else for (int j = 0; j < m; j++) {
                if (currgrid[i - 1][j] == 1) {
                    flip(i, j, currgrid);
                    potans[i][j] = 1;
                }
            }
        }

    }

    static int a = 0;

    static int[][] rec(int[] row, int i) {
        int[][] ans = new int[(int) Math.pow(2.00, row.length)][row.length];
        //if (i == row.length) return row;
        for (int j = i; j < row.length; j++) {
            //ans[a++] = rec(row)
        }
        return ans;
    }

    static void flip(int x, int y, int[][] grid) {
        try {
            grid[x][y] ^= 1;
            grid[x + 1][y] ^= 1;
            grid[x - 1][y] ^= 1;
            grid[x][y + 1] ^= 1;
            grid[x][y - 1] ^= 1;
        } catch (Exception ignored) {
        }
    }

}
