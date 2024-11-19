package SoftProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

public class _3Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/SoftProject/3.txt"));

        int countGoodLines = 0;
        String line;
        while((line = reader.readLine()) != null) {
            if (isContains3Vowels(line) && isContainsDoubleChar(line) && !isContainsRestrictedStr(line)) {
                countGoodLines++;
            }
        }

        reader.close();
        System.out.println(countGoodLines);
    }

    public static boolean isContainsDoubleChar(String str) {
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isContains3Vowels(String str) {
        Set<Character> vowelsSet = Set.of('a', 'e', 'i', 'o', 'u');
        int countVowels = 0;
        for (int i = 0; i < str.length(); i++) {
            if (vowelsSet.contains(str.charAt(i))) {
                countVowels++;
                if (countVowels >= 3) return true;
            }
        }
        return false;
    }

    public static boolean isContainsRestrictedStr(String str) {
        Set<String> restrictedString = Set.of("ab", "cd", "pq", "xy");
        boolean hasRestricted = false;
        for (String rString : restrictedString) {
            hasRestricted = str.contains(rString);
            if (hasRestricted) {
                return true;
            }
        }
        return false;
    }
}
