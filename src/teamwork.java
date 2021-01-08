import java.util.Scanner;

public class teamwork {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] cows = new int[n];

        for (int i = 0; i < n; i++) {
            cows[i] = sc.nextInt();
        }

        int[] dp = new int[n];
        dp[0] = cows[0];
        for (int i = 0; i + 1 < n; i++) {

        }

        int ans = 0;
        System.out.println(ans);

    }

}
