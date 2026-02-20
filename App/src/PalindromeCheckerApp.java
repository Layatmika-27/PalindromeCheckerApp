import java.util.Scanner;
import java.util.Stack;
public class PalindromeCheckerApp {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String word = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }
        boolean isPalindrome = true;
        for (int i = 0; i < word.length(); i++) {
            char poppedChar = stack.pop();
            if (word.charAt(i) != poppedChar) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            System.out.println("The string \"" + word + "\" is a Palindrome.");
        } else {
            System.out.println("The string \"" + word + "\" is NOT a Palindrome.");
        }
        System.out.println("Program exited successfully.");
        sc.close();
    }
}