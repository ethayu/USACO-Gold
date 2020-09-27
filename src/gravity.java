import java.util.*;

public class gravity {

    static class State {
        int gravity;
        int flips;
        Pair pair;
        State (int gravity, int flips, Pair pair) {
            this.gravity = gravity;
            this.flips = flips;
            this.pair = pair;
        }
    }

    static class Pair {
        int x;
        int y;
        Pair (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        Pair c = new Pair(0, 0), d = new Pair(0, 0);
        char[][] world = new char[n][m];
        for (int i = 0; i < n; i++) {
            String row = sc.next();
            for (int j = 0; j < m; j++) {
                world[i][j] = row.charAt(j);
                if (world[i][j] == 'C') {
                    c = new Pair(i, j);
                } else if (world[i][j] == 'D') {
                    d = new Pair(i, j);
                }
            }
        }
        PriorityQueue<State> q = new PriorityQueue<>(new Comparator<State>() {
            @Override
            public int compare(State o1, State o2) {
                return o1.flips - o2.gravity;
            }
        });
        HashSet<Pair> set = new HashSet<>();
        q.add(new State(0, 0, c));
        int ans = -1;
        while(!q.isEmpty()) {
            State curr = q.poll();
            if (set.contains(curr.pair)) continue;
            else set.add(curr.pair);
            if (curr.pair.equals(d)) ans = curr.flips;
            if (curr.gravity == 0) {

            } else {

            }
        }

    }

}
