import java.util.*;

public class QueuesTaleOfTwoStacks {

    private static class MyQueue<T> {
        Stack<T> stackFirst = new Stack<T>();
        Stack<T> stackSecond = new Stack<T>();

        void enqueue(T value) {
            stackFirst.push(value);
        }

        T dequeue() {
            if (stackSecond.isEmpty()) {
                while (!stackFirst.isEmpty()) {
                    stackSecond.push(stackFirst.pop());
                }

                return stackSecond.pop();
            } else {
                return stackSecond.pop();
            }
        }

        String peek() {
            if (stackSecond.isEmpty()) {
                while (!stackFirst.isEmpty()) {
                    stackSecond.push(stackFirst.pop());
                }

                return stackSecond.peek().toString();
            } else {
                return stackSecond.peek().toString();
            }
        }
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
