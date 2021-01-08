import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class hoofpaperscissors {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("hps.in"));
/*
        Scanner sc = new Scanner(System.in);
*/
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] john = new int[n];
        for (int i = 0; i < n; i++) {
            String gesture = sc.next();
            john[i] = gesture.equals("H") ? 0 : gesture.equals("P") ? 1 : 2;
        }

        int[][][] dp = new int[n][k + 2][3];
        dp[0][0][john[0]] = 1;
        for (int i = 0; i + 1 < n; i++) {
            for (int j = 0; j < k + 1; j++) {
                for (int l = 0; l < 3; l++) {
                    dp[i + 1][j][l] = john[i + 1] == l ? Integer.max(dp[i + 1][j][l], dp[i][j][l] + 1) : Integer.max(dp[i + 1][j][l], dp[i][j][l]);
                    dp[i + 1][j + 1][john[i + 1]] = Integer.max(dp[i + 1][j + 1][john[i + 1]], dp[i][j][l] + 1);
                }
            }
        }

        PrintWriter printer = new PrintWriter(new File("hps.out"));
        printer.println(Integer.max(Integer.max(dp[n - 1][k][0], dp[n - 1][k][1]), dp[n - 1][k][2]));
        printer.close();

/*
        System.out.println(Integer.max(Integer.max(dp[n - 1][k][0], dp[n - 1][k][1]), dp[n - 1][k][2]));
*/
    }

}
