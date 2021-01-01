import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeMap;

public class paintbarn {

    static int MOD = 1000000007;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        HashSet<Integer> ones = new HashSet<>();
        TreeMap<Integer, ArrayList<Integer>> adjList = new TreeMap<>();

        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (!adjList.containsKey(a)) adjList.put(a, new ArrayList<>());
            if (!adjList.containsKey(b)) adjList.put(b, new ArrayList<>());
            adjList.get(a).add(b);
            adjList.get(b).add(a);
            if (ones.contains(a)) ones.remove(a);
            else if (adjList.get(a).size() == 1) ones.add(a);
            if (ones.contains(b)) ones.remove(b);
            else if (adjList.get(b).size() == 1) ones.add(b);
        }

        int ret = 0;

        int ans = 1;
        for (int i = 0; i < n - ones.size(); i++) {
            ans *= 2;
            ans %= MOD;
            if (i == ones.size() - 1) ret = ans;
        }

        ans -= ret * ((n - 2 * ones.size()) + 1);
        ans %= MOD;

        System.out.println(ans);

    }

}
