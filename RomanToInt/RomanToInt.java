package RomanToInt;


public class RomanToInt {
    public static void main(String[] args) {
        System.out.println(romanToInt("DIX"));
    }
    public static int romanToInt(String s) {
        int number = 0;
        
        for (int i = 0; i < s.length(); i ++)  {
            if (s.charAt(i) ==  'I') {
                number++;
                if ((i + 1) < s.length() && (s.charAt(i + 1) == 'X' || s.charAt(i + 1) == 'V' )) {
                    number -= 2;
                }
            }
            else if (s.charAt(i) == 'V' ) {
                number += 5;
            }
            else if (s.charAt(i) == 'X' ) {
                number += 10;
                if ((i + 1) < s.length() && ( s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C')) {
                    number -= 20;
                }
            }
            else if (s.charAt(i) == 'L') {
                number += 50;
            }
            else if (s.charAt(i) == 'C') {
                number += 100;
                if ((i + 1) < s.length() && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M')) {
                    number -= 200;
                }
            }
            else if (s.charAt(i) == 'D') {
                number += 500;
            }
            else if (s.charAt(i) == 'M') {
                number += 1000;
            }
        }
        return number;
    }
}
