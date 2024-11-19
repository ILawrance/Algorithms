package SoftProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class _9Task {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/SoftProject/9.txt"));
        String line;
        long summ = 0;
        while ((line = br.readLine()) != null) {
            if (line.contains("-")) {
                line = line.replace("-", "");
                summ -= Long.parseLong(line);
            }
            else if (line.contains("+")) {
                line = line.replace("+", "");
                summ += Long.parseLong(line);
            }
        }
        br.close();
        System.out.println(summ);
    }
}