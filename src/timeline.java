import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class timeline {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int c = sc.nextInt();
        int[] times = new int[n + 1];
        int[][] adj = new int[n + 1][n + 1];
        int[] in = new int[n + 1];
        boolean[] vis = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < times.length; i++) {
            times[i] = sc.nextInt();
        }
        for (int i = 0; i < c; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), d = sc.nextInt();
            adj[a][b] = d;
            in[b]++;
        }
        for (int i = 1; i < n; i++) {
            if (in[i] == 0) q.add(i);
        }
        while (!q.isEmpty()) {
            int x = q.poll();
            vis[x] = true;
            for (int i = 0; i < n+1; i++) {
                if (adj[x][i] != 0 && !vis[i]) {
                    in[i]--;
                    if (in[i] == 0) q.add(i);
                    times[i] = Integer.max(times[x] + adj[x][i], times[i]);
                }
            }
        }
        for (int i = 1; i < times.length; i++) {
            System.out.println(times[i]);
        }

    }

}
