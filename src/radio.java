import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class radio {

    static class position {

        int x, y;

        position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int dist (position a) {
            return (this.x - a.x) * (this.x - a.x) + (this.y - a.y) * (this.y - a.y);
        }

    }

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("radio.in"));

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = Integer.MAX_VALUE/2;
            }
        }

        dp[0][0] = 0;

        position[] ns = new position[n + 1];
        position[] ms = new position[m + 1];

        position np = new position(sc.nextInt(), sc.nextInt());
        position mp = new position(sc.nextInt(), sc.nextInt());

        String nd = sc.next();
        String md = sc.next();

        ns[0] = new position(np.x, np.y);
        ms[0] = new position(mp.x, mp.y);

        for (int i = 0; i < n; i++) {
            if (nd.charAt(i) == 'N') np.y++;
            else if (nd.charAt(i) == 'E') np.x++;
            else if (nd.charAt(i) == 'S') np.y--;
            else np.x--;
            ns[i + 1] = new position(np.x, np.y);
        }

        for (int i = 0; i < m; i++) {
            if (md.charAt(i) == 'N') mp.y++;
            else if (md.charAt(i) == 'E') mp.x++;
            else if (md.charAt(i) == 'S') mp.y--;
            else mp.x--;
            ms[i + 1] = new position(mp.x, mp.y);
        }

        for (int i = 0; i <= n; i++) { //ns array
            for (int j = 0; j <= m; j++) { //ms array
                if (i + 1 <= n && j <= m) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + ms[j].dist(ns[i + 1]));
                }
                if (i <= n && j + 1 <= m) dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + ns[i].dist(ms[j + 1]));
                if (i + 1 <= n && j + 1 <= m)
                    dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j] + ms[j + 1].dist(ns[i + 1]));
            }
        }

        PrintWriter printer = new PrintWriter(new File("radio.out"));
        printer.println(dp[n][m]);
        printer.close();

    }

}
