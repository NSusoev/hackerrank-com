import java.util.*;

public class LinkedListsDetectCycle {

    private class Node {
        int data;
        Node next;
    }

    private static boolean hasCycle(Node head) {
        if (head == null || head.next == null) {
            return false;
        }

        ArrayList<Node> visited = new ArrayList<>();
        Node currentNode = head;

        while (currentNode != null) {
            if (visited.contains(currentNode)) {
                return true;
            } else {
                visited.add(currentNode);
            }
            currentNode = currentNode.next;
        }

        return false;
    }
}
