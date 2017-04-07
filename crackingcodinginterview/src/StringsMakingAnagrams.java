import java.util.*;

public class StringsMakingAnagrams {

    private static int numberNeeded(String first, String second) {
        int result = 0;
        String stringLower = "";
        String stringBigger = "";
        StringBuilder sbBigger = null;

        if (first.length() < second.length()) {
            stringLower = second;
            stringBigger = first;
        } else {
            stringLower = first;
            stringBigger = second;
        }
        sbBigger = new StringBuilder(stringBigger);

        int i = 0;
        boolean exists = false;
        while (i < stringLower.length()) {
            exists = false;

            for (int j = 0; j < sbBigger.length(); j++) {
                if (stringLower.charAt(i) == sbBigger.charAt(j)) {
                    exists = true;
                    sbBigger.deleteCharAt(j);
                    break;
                }
            }

            if (!exists) {
                result++;
            }
            i++;
        }

        result += sbBigger.length();
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}