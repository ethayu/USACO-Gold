import java.io.FileNotFoundException;
import java.util.*;

public class catchcow {

    static int n, k;

    static int bfs() {
        int min = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(n, 0);
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {n, 0});
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            if (curr[0] == k) min = Math.min(curr[1], min);
            if (curr[1] >= min - 1) continue;
            if (map.containsKey(curr[0])) if (map.get(curr[0]) < curr[1]) continue;
            map.put(curr[0], curr[1]);
            if (curr[0] < k) {
                q.add(new int[] {curr[0] * 2, curr[1] + 1});
                q.add(new int[] {curr[0] + 1, curr[1] + 1});
                q.add(new int[] {curr[0] - 1, curr[1] + 1});
            } else if (curr[0] - k < min - 1) q.add(new int[] {k, curr[1] + (curr[0] - k)});
        }
        return min;
    }

    public static void main (String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        System.out.println(bfs());
    }

}
