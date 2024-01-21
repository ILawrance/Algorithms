package Palindrome;

public class Palindrome3 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121011));
    }
    public static boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int temp = x;
        int reverse = 0;
        while (temp != 0) {
            reverse = reverse*10 + temp % 10;
            temp /= 10;
        }
        return x == reverse;
    }
}