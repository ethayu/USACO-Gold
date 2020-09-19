import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class tractor {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] tractor = new int[]{sc.nextInt(), sc.nextInt()};
        TreeSet<int[]> bales = new TreeSet<>((o1, o2) -> {
            int a = o1[0] - o2[0];
            if (a != 0) return a;
            else return o1[1] - o2[1];
        });
        for (int i = 0; i < n; i++) {
            bales.add(new int[] {sc.nextInt(), sc.nextInt()});
        }
        ArrayList<TreeSet<int[]>> cycles = new ArrayList<>();
        for (int[] i : bales) {

        }
    }

}
