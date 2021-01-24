import java.util.Scanner;

public class lis {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }

        int[] dp = new int[n];
        dp[0] = 1;
        int max = 0;

        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (input[j] < input[i]) dp[i] = Integer.max(dp[i], dp[j] + 1);
            }
            max = Integer.max(max, dp[i]);
        }

        System.out.println(max);
    }

}
