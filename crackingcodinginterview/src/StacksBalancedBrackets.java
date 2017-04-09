import java.util.*;

public class StacksBalancedBrackets {

    private static boolean isBalanced(String expression) {
        if (expression == null) {
            return false;
        }

        Stack<Character> brackets = new Stack<>();
        Character bracket;

        for (int i = 0; i < expression.length(); i++) {
            bracket = expression.charAt(i);

            switch (bracket) {
                case '[':
                    brackets.push(bracket);
                    break;
                case '{':
                    brackets.push(bracket);
                    break;
                case '(':
                    brackets.push(bracket);
                    break;
                case ']':
                    if (brackets.isEmpty() || !brackets.pop().equals('[')) {
                        return false;
                    }
                    break;
                case '}':
                    if (brackets.isEmpty() || !brackets.pop().equals('{')) {
                        return false;
                    }
                    break;
                case ')':
                    if (brackets.isEmpty() || !brackets.pop().equals('(')) {
                        return false;
                    }
                    break;
            }
        }

        if (!brackets.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}