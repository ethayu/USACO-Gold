import java.util.*;

public class  mst2 {

    static void msd(int[][] adj) {
        int[] val = new int[adj.length];
        val[0] = 0;
        Arrays.fill(val, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        pq.add(new int[]{0, 0});
        HashSet<Integer> visited = new HashSet<>();
        while (visited.size() < adj.length) {
            int[] a = pq.poll();
            if (!visited.contains(a[0]))
                val[a[0]] = a[1];
            visited.add(a[0]);
            for (int i = 0; i < adj.length; i++) {
                if (i == a[0]) continue;
                if (!visited.contains(i) && val[i] > adj[a[0]][i]) {
                    pq.add(new int[]{i, adj[a[0]][i]});
                }
            }
        }
        System.out.println(Arrays.stream(val).sum());
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        int[][] adj = new int[n][n];
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            adj[a][b] = sc.nextInt();
            adj[b][a] = adj[a][b];
        }
        msd(adj);

    }

}
