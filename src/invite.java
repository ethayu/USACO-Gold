import java.util.*;

public class invite {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int nofcows = sc.nextInt(), a = 0;
        Set<Integer>[] cows = new Set[nofcows + 1];
        Set<Integer>[] groups = new Set[sc.nextInt()];
        for (int i = 0; i < groups.length; i++) {
            int n = sc.nextInt();
            Set<Integer> group = new HashSet<>();
            for (int j = 0; j < n; j++) {
                int temp = sc.nextInt();
                group.add(temp);
                if (cows[temp] == null) cows[temp] = new HashSet<>();
                cows[temp].add(a);
            }
            groups[a++] = group;
        }
        HashSet<Integer> ans = new HashSet<>();
        Queue<Integer> invite = new LinkedList<Integer>();
        invite.add(1);
        while (!invite.isEmpty()) {
            int cow = invite.poll();
            for (int indexes : cows[cow]) {
                Set<Integer> group = groups[indexes];
                group.remove(cow);
                if (group.size() == 1) {
                    int next = group.iterator().next();
                    invite.add(next);
                    ans.add(next);
                }
            }
        }

        System.out.println(ans.size() + 1);

    }

}
