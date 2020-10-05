import java.util.*;

public class horizon {

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int nofbuildings = sc.nextInt();
        TreeMap<Integer, ArrayList<Pair>> buildings = new TreeMap<>((o1, o2) -> o1 - o2);
        for (int i = 0; i < nofbuildings; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            buildings.computeIfAbsent(a, k -> new ArrayList<>());
            buildings.get(a).add(new Pair(c, 0));
            buildings.computeIfAbsent(b, k -> new ArrayList<>());
            buildings.get(b).add(new Pair(c, 1));
        }

        TreeSet<Integer> currHeights = new TreeSet<>();
        currHeights.add(0);
        int area = 0, x = 0;

        for (int point : buildings.keySet()) {
            area += (point - x) * currHeights.last();
            for (Pair pair : buildings.get(point)) {
                if (pair.y == 0) currHeights.add(pair.x);
                else currHeights.remove(pair.x);
            }
            x = point;
        }

        System.out.println(area);
    }

}
