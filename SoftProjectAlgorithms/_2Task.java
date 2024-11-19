package SoftProject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class _2Task {
    public static void main(String[] args) throws IOException {
        boolean[][] homes = new boolean[20000][20000];
        int X = 10000;
        int Y = 10000;
        homes[X][Y] = true;

        BufferedReader br = new BufferedReader(new FileReader("src/SoftProject/2.txt"));
        String line = br.readLine();
        br.close();
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '^') {
                Y +=1;
            }
            else if (line.charAt(i) == 'v') {
                Y -= 1;
            }
            else if (line.charAt(i) == '>') {
                X += 1;
            }
            else if (line.charAt(i) == '<') {
                X -= 1;
            }
            homes[X][Y] = true;
        }


        long counter = 0;
        for (boolean[] homesLine : homes) {
            for (boolean home : homesLine) {
                if (home) {
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }
}
