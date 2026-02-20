import java.util.Scanner;
public class PalindromeCheckerApp {
    public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter a string: ");
                String word = sc.nextLine();
                char[] characters = word.toCharArray();
                int start = 0;
                int end = characters.length - 1;
                boolean isPalindrome = true;
                while (start < end) {
                    if (characters[start] != characters[end]) {
                        isPalindrome = false;
                        break;
                    }
                    start++;
                    end--;
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