import java.util.*;

public class msquare {

    static int[] bigsquare = new int[8];

    static class Square {
        int[] numbers;
        int i;
        String str;

        Square(int[] numbers, int i, String str) {
            this.numbers = numbers;
            this.i = i;
            this.str = str;
        }
    }

    static String bfs() {
        HashSet<Integer> set = new HashSet<>();
        Queue<Square> q = new LinkedList<>();
        q.add(new Square(new int[]{1, 2, 3, 4, 8, 7, 6, 5}, 0, ""));
        while (!q.isEmpty()) {
            Square curr = q.poll();
            if (!toInt(curr.numbers).equals(toInt(bigsquare))) {
                if (set.contains(toInt(curr.numbers))) continue;
                set.add(toInt(curr.numbers));
                q.add(new Square(a(curr.numbers), curr.i + 1, curr.str + 'A'));
                q.add(new Square(b(curr.numbers), curr.i + 1, curr.str + 'B'));
                q.add(new Square(c(curr.numbers), curr.i + 1, curr.str + 'C'));
            } else return curr.str;
        }
        return "";
    }

    static Integer toInt(int[] array) {
        int ans = 0;
        for (int j : array) {
            ans *= 10;
            ans += j;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        bigsquare[0] = sc.nextInt();
        bigsquare[1] = sc.nextInt();
        bigsquare[2] = sc.nextInt();
        bigsquare[3] = sc.nextInt();
        bigsquare[7] = sc.nextInt();
        bigsquare[6] = sc.nextInt();
        bigsquare[5] = sc.nextInt();
        bigsquare[4] = sc.nextInt();
        String ans = bfs();
        System.out.println(ans.length());
        System.out.println(ans);
    }

    static int[] a(int[] square) {
        return new int[]{square[4], square[5], square[6], square[7], square[0], square[1], square[2], square[3]};
    }

    static int[] b(int[] square) {
        return new int[]{square[3], square[0], square[1], square[2], square[7], square[4], square[5], square[6]};
    }

    static int[] c(int[] square) {
        int a = square[1];
        square[1] = square[5];
        square[5] = square[6];
        square[6] = square[2];
        square[2] = a;
        return square;
    }
}
