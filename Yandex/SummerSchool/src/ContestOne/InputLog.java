package ContestOne;

import java.util.ArrayList;
import java.util.Scanner;

public class InputLog {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String aQuery = scanner.next();
        String bInput = scanner.next();
        scanner.close();
        int index = 0;
        ArrayList<Character> word = new ArrayList<>();
        ArrayList<Character> action = new ArrayList<>();
        boolean isAction = false;
        for (char ch: bInput.toCharArray()) {
            if (ch == '<') {
                isAction = true;
            }
            else if (ch == '>') {
                isAction = false;
                StringBuilder actionStr = new StringBuilder();
                for (char cmd : action) {
                    actionStr.append(cmd);
                }
                String actionString = actionStr.toString();
                switch (actionString) {
                    case "left" -> {
                        if (index > 0) {
                            index--;
                        }
                    }
                    case "right" -> {
                        if (index < word.size()) {
                            index++;
                        }
                    }
                    case "bspace" -> {
                        if (index > 0) {
                            word.remove(index - 1);
                            index--;
                        }
                    }
                    case "delete" -> {
                        if (index < word.size()) {
                            word.remove(index);
                        }
                    }
                }
                action.clear();
            }
            else if (isAction) {
                action.add(ch);
            }
            else {
                word.add(index, ch);
                index++;
            }
        }

        StringBuilder wordStr = new StringBuilder();
        for (char w : word) {
            wordStr.append(w);
        }
        String wordString = wordStr.toString();
        if (aQuery.equals(wordString)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}