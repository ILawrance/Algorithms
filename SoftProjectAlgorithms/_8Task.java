package SoftProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class _8Task {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/SoftProject/8.txt"));
        String line;
        int counterDoubleChar = 0;
        int counterTripleChar = 0;
        while ((line = br.readLine()) != null) {
            if (containsDoubleChar(line)) {
                counterDoubleChar++;
            }
            if (containsTripleChar(line)) {
                counterTripleChar++;
            }
        }
        br.close();
        int answer = counterDoubleChar * counterTripleChar;
        System.out.println(answer);
    }

    public static boolean containsDoubleChar(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 2) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsTripleChar(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);

        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 3) {
                return true;
            }
        }
        return false;
    }
}
