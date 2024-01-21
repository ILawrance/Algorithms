package Palindrome;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(11011));
    }
    public static boolean isPalindrome(int x) {
        String palindrom = Integer.toString(x);
        String[] arrayPalondrom = palindrom.split("");
        boolean isPalindr = true;
            for (int i = 0; i <= arrayPalondrom.length/2 - 1; i++) {
                if (!arrayPalondrom[i].equals(arrayPalondrom[arrayPalondrom.length-1-i])) {
                    isPalindr = false;
                }
            }
        return isPalindr;
    }
}
