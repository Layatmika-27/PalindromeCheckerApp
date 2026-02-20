import java.util.*;
public class PalindromeCheckerApp{
    public static boolean twoPointer(String word) {
        int start = 0;
        int end = word.length() - 1;
        while (start < end) {
            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    // Stack
    public static boolean stackMethod(String word) {
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
    // Deque
    public static boolean dequeMethod(String word) {
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        System.out.println("\nRunning performance comparison...\n");
        long startTime = System.nanoTime();
        boolean result1 = twoPointer(input);
        long endTime = System.nanoTime();
        long time1 = endTime - startTime;
        startTime = System.nanoTime();
        boolean result2 = stackMethod(input);
        endTime = System.nanoTime();
        long time2 = endTime - startTime;
        startTime = System.nanoTime();
        boolean result3 = dequeMethod(input);
        endTime = System.nanoTime();
        long time3 = endTime - startTime;
        System.out.println("Palindrome Result: " + result1);
        System.out.println("-----------------------------------");
        System.out.println("Two-Pointer Time: " + time1 + " ns");
        System.out.println("Stack Method Time: " + time2 + " ns");
        System.out.println("Deque Method Time: " + time3 + " ns");
        sc.close();
    }
}