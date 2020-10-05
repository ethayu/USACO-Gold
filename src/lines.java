import java.util.ArrayList;
import java.util.Scanner;

public class lines {

    static class Pair {
        int y, x;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pair[] points = new Pair[sc.nextInt()];
        for (int i = 0; i < points.length; i++) {
            points[i] = new Pair(sc.nextInt(), sc.nextInt());
        }
        ArrayList<Pair> slopes = new ArrayList<>();
        int length = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                Pair currSlope = new Pair(points[j].y - points[i].y, points[j].x - points[i].x);
                boolean exists = true;
                for (Pair slope : slopes) {
                    if (slope.y * currSlope.x == slope.x * currSlope.y) {
                        exists = false;
                        break;
                    }
                }
                if (exists) {
                    length++;
                    slopes.add(currSlope);
                }
            }
        }
        System.out.println(length);
    }
}
