// Задача на нахождение максимальной площади прямоугольника сформированного отрезками

package HHAgaing.Task1MaxSquare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        reader.close();
        int[] length = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            length[i] = Integer.parseInt(input[i]);
        }
        System.out.println(solution(length));
    }

    public static int solution(int[] length) {
        int n = length.length;
        int leftPos = 0;
        int rightPos = n - 1;
        int maxSquare = 0;
        int height, width;
        while (leftPos < rightPos) {
            height = Math.min(length[leftPos], length[rightPos]);
            width = rightPos - leftPos;
            maxSquare = Math.max(maxSquare, width * height);
            if (length[leftPos] < length[rightPos]) leftPos++;
            else rightPos--;
        }
        return maxSquare;
    }
}
