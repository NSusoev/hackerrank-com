import java.util.*;

public class HashTablesRansomNote {

    private enum CanReplicateNote {
        YES,
        NO
    }

    private static CanReplicateNote isCanReplicateNote(String[] magazine, String[] ransom) {
        HashMap<String, Integer> dict = new HashMap<>();

        for (String word : magazine) {
            if (!dict.containsKey(word)) {
               dict.put(word, 1);
            } else {
               dict.put(word, dict.get(word) + 1);
            }
        }

        for (String word : ransom) {
            if (dict.containsKey(word)) {
                if (dict.get(word) > 1) {
                    dict.put(word, dict.get(word) - 1);
                } else {
                    dict.remove(word);
                }
            } else {
                return CanReplicateNote.NO;
            }
        }

        return CanReplicateNote.YES;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for (int magazine_i = 0; magazine_i < m; magazine_i++) {
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for (int ransom_i = 0; ransom_i < n; ransom_i++) {
            ransom[ransom_i] = in.next();
        }

        switch (isCanReplicateNote(magazine, ransom)) {
            case YES:
                System.out.print("Yes");
                break;
            case NO:
                System.out.print("No");
                break;
        }
    }
}