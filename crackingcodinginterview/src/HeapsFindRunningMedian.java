import java.util.*;

public class HeapsFindRunningMedian {

    private static class MinHeap {
        static int capacity = 10;
        static int size = 0;
        static int[] items = new int[capacity];

        static int getParentIndex(int childIndex) {
            return (childIndex - 1) / 2;
        }

        static int getLeftChildIndex(int parentIndex) {
            return 2 * parentIndex + 1;
        }

        static int getRightChildIndex(int parentIndex) {
            return 2 * parentIndex + 2;
        }

        static boolean hasLeftChild(int parentIndex) {
            return getLeftChildIndex(parentIndex) < size;
        }

        static boolean hasRightChild(int parentIndex) {
            return getRightChildIndex(parentIndex) < size;
        }

        static boolean hasParent(int childIndex) {
            return getParentIndex(childIndex) >= 0;
        }

        static int leftChild(int parentIndex) {
            return items[getLeftChildIndex(parentIndex)];
        }

        static int rightChild(int parentIndex) {
            return items[getRightChildIndex(parentIndex)];
        }

        static int parent(int childIndex) {
            return items[getParentIndex(childIndex)];
        }

        static void swap(int indexOne, int indexTwo) {
            int temp = items[indexOne];
            items[indexOne] = items[indexTwo];
            items[indexTwo] = temp;
        }

        static void ensureCapacity() {
            if (size == capacity) {
                capacity = capacity << 1;
                items = Arrays.copyOf(items, capacity);
            }
        }

        static void add(int item) {
            ensureCapacity();
            items[size] = item;
            size++;
            heapifyUp();
        }

        static void heapifyUp() {
            int index = size - 1;

            while (hasParent(index) && parent(index) > items[index]) {
                swap(getParentIndex(index), index);
                index = getParentIndex(index);
            }
        }

        static void heapifyDown() {
            int index = 0;
            while(hasLeftChild(index)) {
                int smallerChildIndex = getLeftChildIndex(index);

                if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                    smallerChildIndex = getRightChildIndex(index);
                }

                if(items[index] < items[smallerChildIndex]) {
                    break;
                }
                else {
                    swap(index, smallerChildIndex);
                }
                index = smallerChildIndex;
            }
        }

        static int extractMin() throws Exception {
            if (size == 0) {
                throw new Exception("Empty heap");
            }

            int item = items[0];
            items[0] = items[size - 1];
            size--;
            heapifyDown();
            return item;
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        ArrayList<Integer> sorted = new ArrayList<>();
        ArrayList<Float> medians = new ArrayList<>();

        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();

            for (int step = 0; step <= a_i; step++) {
                MinHeap.add(a[step]);
            }

            getSortedListFromHeap(MinHeap.items, sorted);

            if (sorted.size() > 0) {
                medians.add(getMedian(sorted));
                sorted.clear();
            }
        }

        for (float median : medians) {
            System.out.println(median);
        }
    }

    private static void getSortedListFromHeap(int[] heap, ArrayList<Integer> sorted) {
        while (MinHeap.size > 0) {
            try {
                sorted.add(MinHeap.extractMin());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static float getMedian(ArrayList<Integer> sorted) {
        int listSize = sorted.size();

        if (listSize % 2 != 0) {
            return sorted.get(listSize / 2);
        } else {
            return (float)(sorted.get(listSize / 2 - 1) + sorted.get(listSize / 2)) / 2;
        }
    }
}