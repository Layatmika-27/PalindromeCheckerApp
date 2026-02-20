import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String word = sc.nextLine();
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            queue.add(ch);     // Enqueue
            stack.push(ch);    // Push
        }
        boolean isPalindrome = true;
        while (!queue.isEmpty()) {
            char fromQueue = queue.remove();  // Dequeue
            char fromStack = stack.pop();     // Pop
            if (fromQueue != fromStack) {
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