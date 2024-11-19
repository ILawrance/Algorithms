package SoftProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class _10Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/SoftProject/10.txt"));
        int[][] grid = new int[50][6];

        String line;
        while ((line = reader.readLine()) != null) {

            if (line.contains("rect ")) {
                creatLight(line, grid);
            }

            else if (line.contains("rotate row ")) {
                rotateRow(line, grid);
            }

            else if (line.contains("rotate column ")) {
                rotateColumn(line, grid);
            }
        }
        reader.close();

        int counter = 0;
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 6; j++) {
                if (grid[i][j] == 1) {
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }

    private static void rotateColumn(String line, int[][] grid) {
        line = line.replace("rotate column x=", ""); // т.е. выбираем из большего (50), а двигаем меньшее
        String[] XSteps = line.split(" by ");
        int X = Integer.parseInt(XSteps[0]);
        int steps = Integer.parseInt(XSteps[1]);
        int realSteps = steps % 6;
        int[][] copy = new int[50][6];

        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 6; j++) {
                copy[i][j] = grid[i][j];
            }
        }

        for (int j = 0; j < 6; j++) {
            grid[X][j] = 0;
        }

        for (int j = 0; j < 6; j++) {
            if (copy[X][j] == 1) {
                int actualPosition = (j + realSteps) % 6;
                grid[X][actualPosition] = 1;
            }
        }
    }

    private static void rotateRow(String line, int[][] grid) { //ЧЕКНУТ
        line = line.replace("rotate row y=", ""); //у меня Y это Х, т.е. выбираем из меньшего (6), значит двигаем большее
        String[] YSteps = line.split(" by ");
        int Y = Integer.parseInt(YSteps[0]);
        int steps = Integer.parseInt(YSteps[1]);
        int realSteps = steps % 50;
        int[][] copy = new int[50][6];

        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 6; j++) {
                copy[i][j] = grid[i][j];
            }
        }

        for (int i = 0; i < 50; i++) {
            grid[i][Y] = 0;
        }

        for (int i = 0; i < 50; i++) {
            if (copy[i][Y] == 1) {
                int actualPosition = (i + realSteps) % 50;
                grid[actualPosition][Y] = 1;
            }
        }
    }

    private static void creatLight(String line, int[][] grid) {
        line = line.replace("rect ", "");
        String[] XY = line.split("x");
        int X = Integer.parseInt(XY[0]);
        int Y = Integer.parseInt(XY[1]);

        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                grid[i][j] = 1;
            }
        }
    }
}
