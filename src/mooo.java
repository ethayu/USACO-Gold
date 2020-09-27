import java.util.Scanner;
import java.util.Stack;

public class mooo {

    static class Cow {
        int height;
        int index;
        int voice;

        Cow(int a, int b, int c) {
            this.height = a;
            this.index = b;
            this.voice = c;
        }

        static Cow clone(Cow cow) {
            return new Cow(cow.height, cow.index, cow.voice);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Stack<Cow> left = new Stack<>();
        int[] heard = new int[sc.nextInt()];
        Cow[] cows = new Cow[heard.length];
        int i = 0;
        while (sc.hasNextInt()) {
            cows[i] = new Cow(sc.nextInt(), i, sc.nextInt());
            Cow curr = Cow.clone(cows[i]);
            while (left.peek().height < curr.height) {
                left.pop();
            }

        }

    }

}
