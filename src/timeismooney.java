import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class timeismooney {

    public static void main(String[] args) throws FileNotFoundException {

        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new File("time.in"));
        int n = sc.nextInt();
        int m = sc.nextInt();
        int c = sc.nextInt();
        int[] ns = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ns[i] = sc.nextInt();
        }
        ArrayList<Integer>[] adjList = new ArrayList[n + 1];
        for (int i = 0; i < m; i++) {
            int ret = sc.nextInt();
            if (adjList[ret] == null) adjList[ret] = new ArrayList<>();
            adjList[ret].add(sc.nextInt());
        }
        int[][] dp = new int[1001][n + 1];

        for (int city : adjList[1]) {
            dp[1][city] = ns[city];
        }

        int ans = 0;
        for (int i = 1; i < 1001; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (dp[i][j] != 0 && i != 1000) {
                    if (adjList[j] != null) for (int city : adjList[j]) {
                        dp[i + 1][city] = Integer.max(dp[i + 1][city], dp[i][j] + ns[city]);
                    }
                }
            }
            ans = Integer.max(ans, dp[i][1] - c * i * i);
        }

        PrintWriter printer = new PrintWriter(new File("time.out"));
        //System.out.println(ans);
        printer.println(ans);
        printer.close();

    }

}
