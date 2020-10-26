import java.util.*;

public class roads {

    static void msd(double[][] adj) {
        double[] val = new double[adj.length];
        val[0] = 0;
        Arrays.fill(val, Integer.MAX_VALUE);
        PriorityQueue<double[]> pq = new PriorityQueue<double[]>(new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                return (int) (o1[1] - o2[1]);
            }
        });
        pq.add(new double[]{0, 0});
        HashSet<Integer> visited = new HashSet<>();
        while (visited.size() < adj.length) {
            double[] a = pq.poll();
            if (!visited.contains(a[0]))
                val[(int) a[0]] = a[1];
            visited.add((int) a[0]);
            for (int i = 0; i < adj.length; i++) {
                if (i == a[0]) continue;
                if (!visited.contains(i) && val[i] > adj[(int) a[0]][i]) {
                    pq.add(new double[]{i, adj[(int) a[0]][i]});
                }
            }
        }
        System.out.printf("%.2f", Arrays.stream(val).sum());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] coords = new int[n][n];
        for (int i = 0; i < n; i++) {
            coords[i][0] = sc.nextInt();
            coords[i][1] = sc.nextInt();
        }
        double[][] adj = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double dx = coords[i][0] - coords[j][0];
                double dy = coords[i][1] - coords[j][1];
                adj[i][j] = Math.sqrt(dx * dx + dy * dy);
            }
        }
        for (int i = 0; i < m; i++) {
            adj[sc.nextInt() - 1][sc.nextInt() - 1] = 0;
        }
        msd(adj);
    }

}
