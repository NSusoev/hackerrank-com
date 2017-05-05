import java.util.*;

public class SortingBubbleSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int[] array = new int[len];

        for (int j = 0; j < len; j++) {
            array[j] = in.nextInt();
        }

        System.out.println(String.format("Array is sorted in %d swaps.", bubbleSort(array)));
        System.out.println(String.format("First Element: %d", array[0]));
        System.out.println(String.format("Last Element: %d", array[len - 1]));
    }

    private static int bubbleSort(int[] a) {
        int n = a.length;
        int numberOfSwaps = 0;

        for (int i = 0; i < n; i++) {
            // Track number of elements swapped during a single array traversal

            for (int j = 0; j < n - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    numberOfSwaps++;
                }
            }

            // If no elements were swapped during a traversal, array is sorted
            if (numberOfSwaps == 0) {
                break;
            }
        }

        return numberOfSwaps;
    }

    private static void swap(int[] array, int indexOfBiggerNumber, int indexOfLowerNumber) {
        int tmp = array[indexOfLowerNumber];
        array[indexOfLowerNumber] = array[indexOfBiggerNumber];
        array[indexOfBiggerNumber] = tmp;
    }
}
