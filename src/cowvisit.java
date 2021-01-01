import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class cowvisit {

    static class barn {
        int x, y;

        barn(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        barn[] barns = new barn[n];
        int[] best = new int[n];

        for (int i = 0; i < n; i++) {
            barns[i] = new barn(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(barns, Comparator.comparingInt(o -> o.x));

        best[n - 2] = (barns[n - 1].x - barns[n - 2].x + barns[n - 1].y < barns[n - 2].y) ? n - 2 : n - 1;

        for (int i = n - 3; i >= 0; i--) {
            if (barns[best[i + 1]].x - barns[i].x + barns[best[i + 1]].y < barns[i].y) best[i] = i; else best[i] = best[i + 1];
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (best[i] != i) max = Integer.max(max, barns[i].y + barns[best[i]].y - barns[i].x + barns[best[i]].x);
        }

        System.out.println(max);

    }

}
