package SoftProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class _4Task {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/SoftProject/4.txt"));

        Character[][] messages = new Character[598][8];
        String string;

        // Записал все в массив чаров
        for (int i = 0; i < 598; i++) {
            string = br.readLine();
            string = string.trim();
            for (int j = 0; j < 8; j++) {
                messages[i][j] = string.charAt(j);
            }
        }
        br.close();

        // записал количество символов в мапу для каждого столбца и вывел макс встречающийся чар
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < 8; j ++) {
            Character maxChar = getMaxChar(messages, j);
            stringBuilder.append(maxChar);
        }
        System.out.println(stringBuilder);
    }

    private static Character getMaxChar(Character[][] messages, int j) {
        HashMap<Character, Integer> charsCountMap = new HashMap<>();
        for (int i = 0; i < 598; i++) {
            charsCountMap.put(messages[i][j], charsCountMap.getOrDefault(messages[i][j], 0) + 1);
        }
        int max = -1;
        Character maxChar = null;
        for (int i = 0; i < 598; i++) {
            if (charsCountMap.containsKey(messages[i][j])) {
                if (charsCountMap.get(messages[i][j]) > max) {
                    max = charsCountMap.get(messages[i][j]);
                    maxChar = messages[i][j];
                }
            }
        }
        return maxChar;
    }
}
