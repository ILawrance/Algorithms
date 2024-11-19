package SoftProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class _5Task {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/SoftProject/5.txt"));
        String line;
        long[][] gridLight = new long[1000][1000];
        long glowingStrength = 0;

        while ((line = br.readLine()) != null) {

            if (line.contains("turn on ")) {
                line = line.replace("turn on ", "");
                String[] leftAndRightXY = line.split(" through ");
                String[] leftXY = leftAndRightXY[0].split(",");
                String[] rightXY = leftAndRightXY[1].split(",");
                int leftX = Integer.parseInt(leftXY[0]);
                int leftY = Integer.parseInt(leftXY[1]);
                int rightX = Integer.parseInt(rightXY[0]);
                int rightY = Integer.parseInt(rightXY[1]);

                for (int i = leftX; i <= rightX; i++) {
                    for (int j = leftY; j <= rightY; j++) {
                        gridLight[i][j]++;
                    }
                }
            }
            else if (line.contains("turn off ")) {
                line = line.replace("turn off ", "");
                String[] leftAndRightXY = line.split(" through ");
                String[] leftXY = leftAndRightXY[0].split(",");
                String[] rightXY = leftAndRightXY[1].split(",");
                int leftX = Integer.parseInt(leftXY[0]);
                int leftY = Integer.parseInt(leftXY[1]);
                int rightX = Integer.parseInt(rightXY[0]);
                int rightY = Integer.parseInt(rightXY[1]);

                for (int i = leftX; i <= rightX; i++) {
                    for (int j = leftY; j <= rightY; j++) {
                        gridLight[i][j]--;
                        if (gridLight[i][j] < 0) {
                            gridLight[i][j] = 0;
                        }
                    }
                }
            }
            else if (line.contains("toggle ")) {
                line = line.replace("toggle ", "");
                String[] leftAndRightXY = line.split(" through ");
                String[] leftXY = leftAndRightXY[0].split(",");
                String[] rightXY = leftAndRightXY[1].split(",");
                int leftX = Integer.parseInt(leftXY[0]);
                int leftY = Integer.parseInt(leftXY[1]);
                int rightX = Integer.parseInt(rightXY[0]);
                int rightY = Integer.parseInt(rightXY[1]);

                for (int i = leftX; i <= rightX; i++) {
                    for (int j = leftY; j <= rightY; j++) {
                        gridLight[i][j] += 2;
                    }
                }
            }
        }

        br.close();

        for (long[] row : gridLight) {
            for (long light : row) {
                glowingStrength += light;
            }
        }
        System.out.println(glowingStrength);
    }
}
