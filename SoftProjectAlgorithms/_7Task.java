package SoftProject;

import java.io.IOException;
import java.util.HashMap;

public class _7Task {
    public static void main(String[] args) throws IOException {
        String word = "1113222113";
        String testWord = "1";
        for (int i = 0; i < 40; i++) {
            word = lookAndSay(word);
        }
        System.out.println(word.length());
    }

    public static String lookAndSay(String word) {
        StringBuilder stringBuilder = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put(word.charAt(0), 1);
        for (int i = 1; i < word.length(); i++) {
            if (map.containsKey(word.charAt(i))) {
                map.put(word.charAt(i), map.get(word.charAt(i)) + 1);
            }
            else {
                stringBuilder.append(map.get(word.charAt(i - 1)));
                stringBuilder.append(word.charAt(i - 1));
                map.clear();
                map.put(word.charAt(i), 1);
            }
        }
        stringBuilder.append(map.get(word.charAt(word.length() - 1)));
        stringBuilder.append(word.charAt(word.length() - 1));
        return stringBuilder.toString();
    }
}
