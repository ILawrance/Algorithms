package YandexTren.Training5.ThirdWeek.Problem3B;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstStr = scan.nextLine();
        String secondStr = scan.nextLine();
        scan.close();
        Dictionary<Character, Integer> charsCount = new Hashtable<>();
        for (int i = 0; i < firstStr.length(); i++) {
            if (charsCount.get(firstStr.charAt(i)) != null) {
                charsCount.put(firstStr.charAt(i), charsCount.get(firstStr.charAt(i)) + 1);
            }
            else {
                charsCount.put(firstStr.charAt(i), 1);
            }
        }
        for (int i = 0; i < secondStr.length(); i++) {
            if (charsCount.get(secondStr.charAt(i)) != null) {
                if (charsCount.get(secondStr.charAt(i)) > 0) {
                    charsCount.put(secondStr.charAt(i), charsCount.get(secondStr.charAt(i)) - 1);
                }
                else {
                    System.out.println("NO");
                    return;
                }
            }
            else {
                System.out.println("NO");
                return;
            }
        }
        Enumeration<Character> keys = charsCount.keys();
        for (int i = 0; i < charsCount.size(); i ++) {
            char key = keys.nextElement();
            if (charsCount.get(key) > 0) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}