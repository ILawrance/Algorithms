package Palindrome;

public class Palindrome2 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(25352));
    }
    public static boolean isPalindrome(int x) {
        String palindrom = Integer.toString(x);
        String[] arrayPalindrome = palindrom.split("");
        String[] arrayPalindromeRev = new String[arrayPalindrome.length];
        for (int i = 0; i < arrayPalindrome.length; i++) {
            arrayPalindromeRev[arrayPalindromeRev.length-1-i] = arrayPalindrome[i];
        }
        String string = "";
        String string2 = "";
        for (String str : arrayPalindrome) {
            string += str;
        }
        for (String str2 : arrayPalindromeRev) {
            string2 += str2;
        }
        return string.equals(string2);
    }
}
