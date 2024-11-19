package YandexTren.Training5.SecondWeek.Problem2D;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countVipilKletok = Integer.parseInt(scan.nextLine());
        boolean[][] isVipilKletka = new boolean[8][8];
        for (int i = 1; i < countVipilKletok + 1; i ++) {
                String[] tempCoordStrArr = scan.nextLine().split(" ");
                isVipilKletka[Integer.parseInt(tempCoordStrArr[0]) - 1][Integer.parseInt(tempCoordStrArr[1]) - 1] = true;
        }
        int countPerimetr = 0;
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                if (isVipilKletka[i-1][j-1]) {
                    if (i - 1 < 1) {
                        countPerimetr++;
                    }
                    else {
                        if (!isVipilKletka[i-2][j-1]) {
                            countPerimetr++;
                        }
                    }
                    if (i + 1 == 9) {
                        countPerimetr++;
                    }
                    else {
                        if (!isVipilKletka[i][j-1]) {
                            countPerimetr++;
                        }

                    }
                    if (j - 1 < 1) {
                        countPerimetr++;
                    }
                    else {
                        if (!isVipilKletka[i-1][j-2]) {
                            countPerimetr++;
                        }

                    }
                    if (j + 1 == 9) {
                        countPerimetr++;
                    }
                    else {
                        if (!isVipilKletka[i-1][j]) {
                            countPerimetr++;
                        }
                    }
                }
            }
        }
        System.out.println(countPerimetr);
    }
}