import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class auto {

    static int binarySearch(String[] arr, int l, int r, String x) {
        if (r >= l) {
            int mid = (r - l) / 2;
            if (arr[mid].startsWith(x)) {
                for (int i = mid; i >= -1; i--) {
                    if (i == -1) return 0;
                    if (!arr[i].startsWith(x)) {
                        return i + 1;
                    }
                }
            }
            if (arr[mid].compareTo(x) > 0)
                return binarySearch(arr, l, mid - 1, x);
            return binarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt(), n = sc.nextInt();
        String[] words = new String[w];
        HashMap<String, Integer> indexes = new HashMap<>();
        for (int i = 0; i < w; i++) {
            words[i] = sc.next();
            indexes.put(words[i], i);
        }
        Arrays.sort(words);
        for (int i = 0; i < n; i++) {
            int index = sc.nextInt();
            String input = sc.next();
            int output = binarySearch(words, 0, w - 1, input);
            if ((output == -1) || (output + index - 1 >= w)) System.out.println(-1);
            else System.out.println(indexes.get(words[output + index - 1]) + 1);
        }

    }

}
