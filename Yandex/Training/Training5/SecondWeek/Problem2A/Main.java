package YandexTren.Training5.SecondWeek.Problem2A;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sumCoordinate = Integer.parseInt(scan.nextLine());

        int[] maxCoords = new int[2];
        int[] minCoords = new int[2];
        String coordinateXY = scan.nextLine();
        String[] coordinateXYArr = coordinateXY.split(" ");
        minCoords[0] = Integer.parseInt(coordinateXYArr[0]);
        minCoords[1] = Integer.parseInt(coordinateXYArr[1]);
        maxCoords[0] = Integer.parseInt(coordinateXYArr[0]);
        maxCoords[1] = Integer.parseInt(coordinateXYArr[1]);
        for (int i = 0; i < sumCoordinate-1; i++) {
            coordinateXY = scan.nextLine();
            coordinateXYArr = coordinateXY.split(" ");
            int Xcoord = Integer.parseInt(coordinateXYArr[0]);
            int Ycoord = Integer.parseInt(coordinateXYArr[1]);
            if (maxCoords[0] < Xcoord) {
                maxCoords[0] = Xcoord;
            }
            if (maxCoords[1] < Ycoord) {
                maxCoords[1] = Ycoord;
            }
            if (minCoords[0] > Xcoord) {
                minCoords[0] = Xcoord;
            }
            if (minCoords[1] > Ycoord) {
                minCoords[1] = Ycoord;
            }
        }
        if (sumCoordinate != 1) {
            System.out.println(minCoords[0] + " " + minCoords[1] + " " + maxCoords[0] + " " + maxCoords[1]);
        }
    }
}