import java.util.*;

public class TriesContacts {

    private static class Node {
        HashMap<Character, Node> children = new HashMap<>();
        boolean isCompletedWord;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Node tree = new Node();
        List<Integer> results = new ArrayList<>();

        for (int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();

            switch (op) {
                case "add":
                    addWord(tree, contact, 0, contact.length());
                    break;
                case "find":
                    results.add(countWordsWithPartial(tree, contact, 0, 0));
                    break;
                default:
                    break;
            }
        }

        for (int result : results){
            System.out.println(result);
        }
    }

    private static void addWord(Node tree, String partial, int step, int partialLenght) {
        if (tree == null) {
            throw new IllegalArgumentException("tree is null");
        }

        if (!tree.isCompletedWord) {
            tree.children.put(partial.charAt(step), new Node());

            if (step != partialLenght - 1) {
                addWord(tree.children.get(partial.charAt(step)), partial, ++step, partialLenght);
            } else {
                tree.isCompletedWord = true;
            }
        }
    }

    private static int countWordsWithPartial(Node tree, String partial, int step, int currentCount) {
        return 0;
    }
}