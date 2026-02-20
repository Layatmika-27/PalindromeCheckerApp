import java.util.*;
public class PalindromeCheckerApp {
    //Interface
    interface PalindromeStrategy {
        boolean checkPalindrome(String word);
    }
    static class StackStrategy implements PalindromeStrategy {
        @Override
        public boolean checkPalindrome(String word) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < word.length(); i++) {
                stack.push(word.charAt(i));
            }
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != stack.pop()) {
                    return false;
                }
            }
            return true;
        }
    }
    static class DequeStrategy implements PalindromeStrategy {
        @Override
        public boolean checkPalindrome(String word) {
            Deque<Character> deque = new LinkedList<>();
            for (int i = 0; i < word.length(); i++) {
                deque.addLast(word.charAt(i));
            }
            while (deque.size() > 1) {
                if (deque.removeFirst() != deque.removeLast()) {
                    return false;
                }
            }
            return true;
        }
    }
    static class PalindromeContext {
        private PalindromeStrategy strategy;
        public PalindromeContext(PalindromeStrategy strategy) {
            this.strategy = strategy;
        }
        public boolean execute(String word) {
            return strategy.checkPalindrome(word);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        System.out.println("Choose Strategy:");
        System.out.println("1 - Stack Strategy");
        System.out.println("2 - Deque Strategy");
        int choice = sc.nextInt();
        PalindromeStrategy strategy;
        if (choice == 1) {
            strategy = new StackStrategy();
        } else {
            strategy = new DequeStrategy();
        }
        PalindromeContext context = new PalindromeContext(strategy);
        boolean result = context.execute(input);
        if (result) {
            System.out.println("The string \"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("The string \"" + input + "\" is NOT a Palindrome.");
        }
        System.out.println("Program exited successfully.");
        sc.close();
    }
}