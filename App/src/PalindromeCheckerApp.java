import java.util.Stack;
import java.util.Scanner;
public class PalindromeCheckerApp {
    // Private data member (Encapsulation)
    private String word;
    // Constructor
    public PalindromeCheckerApp(String word) {
        this.word = word;
    }
    public boolean checkPalindrome() {
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
class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string:"); String input = sc.nextLine();
        PalindromeCheckerApp checker = new PalindromeCheckerApp(input);
        if (checker.checkPalindrome()) {
            System.out.println("The string \"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("The string \"" + input + "\" is NOT a Palindrome.");
        }
        System.out.println("Program exited successfully.");
    }
}