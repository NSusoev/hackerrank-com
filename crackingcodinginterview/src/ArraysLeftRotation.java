import java.util.*;

public class ArraysLeftRotation {

    private static int[] rotate(int n, int k, int a[]) {
        for (int i = 0; i < k; i++) {
            int first = a[0];
            for (int j = 0; j < n - 1; j++) {
                a[j] = a[j + 1];
            }
            a[n - 1] = first;
        }

        return a;
    }

    private static String arrayToString(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]);
            if (i != a.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for (int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        System.out.print(arrayToString(rotate(n, k, a)));
    }
}