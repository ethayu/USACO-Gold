import java.util.*;

public class dijkstra {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] dist = new int[sc.nextInt() + 1];
        Arrays.fill(dist, -1);
        int edges = sc.nextInt();
        ArrayList[] adjacencyList = new ArrayList[dist.length - 1];
        for (int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new ArrayList<int[]>();
        }
        int source = sc.nextInt();
        dist[source] = 0;
        for (int i = 0; i < edges; i++) {
            adjacencyList[sc.nextInt()].add(new int[] {sc.nextInt(), sc.nextInt()});
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(source);
        while (!pq.isEmpty()) {
            int curr = pq.poll();
            //dist[curr] = dist[adjacencyList[curr]]

        }

    }

}
