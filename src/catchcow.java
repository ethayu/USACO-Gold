import java.io.FileNotFoundException;
import java.util.Scanner;

public class catchcow {

    static int n, k;

    public static void main (String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        int i = 0;
        while (n != k) {
            if (n < k) {
                if (4*n < k) {
                    n *= 2;
                    i++;
                } else if (Math.abs(k - 2*n) + 1> Math.abs(n - k)) {
                    i += n - k;
                    n = k;
                } else {
                    i += 1 + Math.abs(k - 2*n);
                    n = k;
                }
            } else {
                i += n - k;
                n = k;
            }
        }
        System.out.println(i);
    }

}
