package Task2;
// Сейчас не оснвоной (медленноват)
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] NM = scan.nextLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        int[] x1y1 = new int[2];
        String[] x1y1String = scan.nextLine().split(" ");
        for (int i =0; i<2; i++) {
            x1y1[i] = Integer.parseInt(x1y1String[i]);
        }

        Integer[] x2y2 = new Integer[2];
        String[] x2y2String = scan.nextLine().split(" ");
        for (int i =0; i<2; i++) {
            x2y2[i] = Integer.parseInt(x2y2String[i]);
        }

        int[][] Labirint = new int[N][M];
        String[] LabirintLine = new String[M];
        for (int i = 0; i<N; i++) {
            LabirintLine = scan.nextLine().split(" ");
            for (int j =0; j<M; j++) {
                Labirint[i][j] = Integer.parseInt(LabirintLine[j]);
            }
        }
        scan.close();

       // Pair<Integer, Integer> awd = new Pair<Integer, Integer>();

        int[][] StepsInLabirint = new int[N][M];
        StepsInLabirint[x1y1[1]][x1y1[0]] = 0;
        Labirint[x2y2[1]][x2y2[0]] = 2;     // X и Y наоборот идут!!!
        Queue<int[]> Ochered = new LinkedList<int[]>();
        Set<int[]> Memory = new HashSet<int[]>();
        
        Ochered.add(x1y1.clone());
        Memory.add(x1y1);

        while (!Ochered.isEmpty()) {
            int[] tempYX = Ochered.poll();

            if (Labirint[tempYX[1]][tempYX[0]] == 2) {                              //Если выход нашелся
                System.out.println(StepsInLabirint[tempYX[1]][tempYX[0]]);
                return;
            }
            
            if (tempYX[0] - 1 >= 0) {                                               // шаг влево
                tempYX[0] -= 1;
                if ((Labirint[tempYX[1]][tempYX[0]] == 0 || Labirint[tempYX[1]][tempYX[0]] == 2)  && !Memory.contains(tempYX)) {
                    int [] tempTempYX = new int[2];
                    tempTempYX[0] = tempYX[0];
                    tempTempYX[1] = tempYX[1];
                    Ochered.add(tempTempYX.clone());
                    Memory.add(tempTempYX);
                    StepsInLabirint[tempYX[1]][tempYX[0]] = StepsInLabirint[tempYX[1]][tempYX[0] + 1] + 1;
                }
                tempYX[0] += 1;
            }

            if (tempYX[0] + 1 < M) {                                                // шаг вправо
                tempYX[0] += 1;
                if ((Labirint[tempYX[1]][tempYX[0]] == 0 || Labirint[tempYX[1]][tempYX[0]] == 2) && !Memory.contains(tempYX)) {
                    int [] tempTempYX = new int[2];
                    tempTempYX[0] = tempYX[0];
                    tempTempYX[1] = tempYX[1];
                    Ochered.add(tempTempYX.clone());
                    Memory.add(tempTempYX);
                    StepsInLabirint[tempYX[1]][tempYX[0]] = StepsInLabirint[tempYX[1]][tempYX[0]-1] + 1;
                }
                tempYX[0] -= 1;
            }
            
            if (tempYX[1] + 1 < N) {                                         // шаг вниз
                tempYX[1] += 1;
                if ((Labirint[tempYX[1]][tempYX[0]] == 0 || Labirint[tempYX[1]][tempYX[0]] == 2)  && !Memory.contains(tempYX)) {
                    int [] tempTempYX = new int[2];
                    tempTempYX[0] = tempYX[0];
                    tempTempYX[1] = tempYX[1];
                    Ochered.add(tempTempYX.clone());
                    Memory.add(tempTempYX);
                    StepsInLabirint[tempYX[1]][tempYX[0]] = StepsInLabirint[tempYX[1]-1][tempYX[0]] + 1;
                }
                tempYX[1] -= 1;
            }

            if (tempYX[1] - 1 >=0 ) {                              // шаг вверх
                tempYX[1] -= 1;
                if ((Labirint[tempYX[1]][tempYX[0]] == 0 || Labirint[tempYX[1]][tempYX[0]] == 2) && !Memory.contains(tempYX)) {
                    int [] tempTempYX = new int[2];
                    tempTempYX[0] = tempYX[0];
                    tempTempYX[1] = tempYX[1];
                    Ochered.add(tempTempYX.clone());
                    Memory.add(tempTempYX);
                    StepsInLabirint[tempYX[1]][tempYX[0]] = StepsInLabirint[tempYX[1] + 1][tempYX[0]] + 1;
                }
                tempYX[1] += 1;
            }
        }
        System.out.println(0);
        return;
    }
}