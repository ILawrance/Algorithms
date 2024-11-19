package ContestOne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EmoBoy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nick = reader.readLine();
        if (nick.length() < 8) {
            System.out.println("NO");
            return;
        }
        boolean isDigitHere = false;
        boolean isLowerCase = false;
        boolean isUpperCase = false;
        for (int i = 0; i < nick.length(); i ++) {
            if (Character.isDigit(nick.charAt(i))) {
                isDigitHere = true;
            }
            else if (Character.isUpperCase(nick.charAt(i))) {
                isUpperCase = true;
            }
            else if (Character.isLowerCase(nick.charAt(i))) {
                isLowerCase = true;
            }
            if (isDigitHere && isLowerCase && isUpperCase) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}