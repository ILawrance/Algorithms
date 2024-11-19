package YandexTren.Training5.ThirdWeek.Problem3F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        Set<String> wordsBazaToReduce = new HashSet<>(List.of(scan.readLine().split(" ")));
        String[] wordsForReduce = scan.readLine().split(" ");

        for (int s = 0; s < wordsForReduce.length; s++) {
            StringBuilder smallWord = new StringBuilder();
            for (int i = 0; i < wordsForReduce[s].length(); i++) {
                smallWord.append(wordsForReduce[s].charAt(i));
                if (wordsBazaToReduce.contains(smallWord.toString())) {
                    wordsForReduce[s] = smallWord.toString();
                    break;
                }
            }
        }
        System.out.println(String.join(" ", wordsForReduce));
    }
}