package Task2;
 // Работает - мой самый быстрый
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] NM = scan.nextLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        int[] x1y1 = new int[2];
        String[] x1y1String = scan.nextLine().split(" ");
        for (int i =0; i < 2; i++) {
            x1y1[i] = Integer.parseInt(x1y1String[i]);
        }

        Integer[] x2y2 = new Integer[2];
        String[] x2y2String = scan.nextLine().split(" ");
        for (int i =0; i < 2; i++) {
            x2y2[i] = Integer.parseInt(x2y2String[i]);
        }

        int[][] labirint = new int[N][M];
        String[] labirintLine = new String[M];
        for (int i = 0; i < N; i++) {
            labirintLine = scan.nextLine().split(" ");
            for (int j =0; j < M; j++) {
                labirint[i][j] = Integer.parseInt(labirintLine[j]);
            }
        }
        scan.close();

        Queue<int[]> ochered = new LinkedList<int[]>();
        boolean[][] beOrNotBe = new boolean[N][M];
        int[][] stepsInlabirint = new int[N][M];
        stepsInlabirint[x1y1[1]][x1y1[0]] = 0;
        ochered.add(x1y1);
        beOrNotBe[x1y1[1]][x1y1[0]] = true;
        int [] kletka;
        
        while(!ochered.isEmpty()) {
            int[] tempYX = ochered.poll();
            if (labirint[tempYX[1]][tempYX[0]] == 1) { // Если стена
                continue;
            }

            if (tempYX[0] == x2y2[0] && tempYX[1] == x2y2[1]) { // Если выход
                System.out.println(stepsInlabirint[tempYX[1]][tempYX[0]]);
                return;
            }
            if (tempYX[0] - 1 >= 0 || tempYX[0] + 1 < M || tempYX[1] - 1 >= 0 || tempYX[1] + 1 < N ) { // Шаг в лабириинте или нет
                if (tempYX[0] - 1 >= 0) {
                    if (!beOrNotBe[tempYX[1]][tempYX[0] - 1]) {
                        beOrNotBe[tempYX[1]][tempYX[0] - 1] = true;
                        kletka = tempYX.clone();
                        kletka[0] -= 1;
                        ochered.add(kletka);
                        stepsInlabirint[kletka[1]][kletka[0]] = stepsInlabirint[kletka[1]][kletka[0] + 1] + 1;
                    }
                }
                if (tempYX[0] + 1 < M) {
                    if (!beOrNotBe[tempYX[1]][tempYX[0] + 1]) {
                        beOrNotBe[tempYX[1]][tempYX[0] + 1] = true;
                        kletka = tempYX.clone();
                        kletka[0] += 1;
                        ochered.add(kletka);
                        stepsInlabirint[kletka[1]][kletka[0]] = stepsInlabirint[kletka[1]][kletka[0] - 1] + 1;
                    }
                }
                if (tempYX[1] - 1 >= 0) {
                    if (!beOrNotBe[tempYX[1] - 1][tempYX[0]]) {
                        beOrNotBe[tempYX[1] - 1][tempYX[0]] = true;
                        kletka = tempYX.clone();
                        kletka[1] -= 1;
                        ochered.add(kletka);
                        stepsInlabirint[kletka[1]][kletka[0]] = stepsInlabirint[kletka[1] + 1][kletka[0]] + 1;
                    }
                }
                if (tempYX[1] + 1 < N) {
                    if (!beOrNotBe[tempYX[1] + 1][tempYX[0]]) {
                        beOrNotBe[tempYX[1] + 1][tempYX[0]] = true;
                        kletka = tempYX.clone();
                        kletka[1] += 1;
                        ochered.add(kletka);
                        stepsInlabirint[kletka[1]][kletka[0]] = stepsInlabirint[kletka[1] - 1][kletka[0]] + 1;
                    }
                }
            }
        }
        System.out.println(0);
        return;
    }
}