package Task2;
import java.util.HashMap;
import java.util.HashSet;
// Работает, но медленно, перебирает кадый элемент памяти для проверки вхождения //Не оснвоной
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] NM = scan.nextLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
      
        String[] x1y1 = new String[2];
        x1y1 = scan.nextLine().split(" ");
        int x1 = Integer.parseInt(x1y1[0]);
        int y1 = Integer.parseInt(x1y1[1]);

        String[] x2y2 = new String[2];
        x2y2 = scan.nextLine().split(" ");
        int x2 = Integer.parseInt(x2y2[0]);
        int y2 = Integer.parseInt(x2y2[1]);

        int[][] Labirint = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] Stroka = scan.nextLine().split(" ");
            for (int j =0; j < M; j++) {
                Labirint[i][j] = Integer.parseInt(Stroka[j]);
            }
        }
        int[][] StepsInLabirint = new int[N][M];
        StepsInLabirint[y1][x1] = 0;
        scan.close();
        Labirint[y2][x2] = 2;       // X и Y наоборот идут!

        Queue<Integer> Ochered = new LinkedList<Integer>();
        Queue<int[]> Memory = new LinkedList<int[]>();
        Ochered.add(x1y1);
        Memory.add(x1y1);
        
        while (!Ochered.isEmpty()) {
            int[] tempYX = Ochered.poll().clone();
            if (Labirint[tempYX[1]][tempYX[0]] == 2) {                  // Если выход нашелся
                System.out.println(StepsInLabirint[tempYX[1]][tempYX[0]]);
                return;
            }
            
            if (tempYX[0] - 1 >= 0) {                                   // шаг влево
                tempYX[0] -= 1;
                if (chekStep(Labirint, StepsInLabirint, tempYX, Memory, Ochered)) {
                    StepsInLabirint[tempYX[1]][tempYX[0]] = StepsInLabirint[tempYX[1]][tempYX[0] + 1] + 1;
                }
                tempYX[0] += 1;
            }

            if (tempYX[0] + 1 < M) {                                    // шаг вправо
                tempYX[0] += 1;
                if (chekStep(Labirint, StepsInLabirint, tempYX, Memory, Ochered)) {
                    StepsInLabirint[tempYX[1]][tempYX[0]] = StepsInLabirint[tempYX[1]][tempYX[0]-1] + 1;
                }
                tempYX[0] -= 1;
            }
            
            if (tempYX[1] + 1 < N) {                                    // шаг вниз
                tempYX[1] += 1;
                if (chekStep(Labirint, StepsInLabirint, tempYX, Memory, Ochered)) {
                    StepsInLabirint[tempYX[1]][tempYX[0]] = StepsInLabirint[tempYX[1]-1][tempYX[0]] + 1;
                }
                tempYX[1] -= 1;
            }

            if (tempYX[1] - 1 >=0 ) {                                     // шаг вверх
                tempYX[1] -= 1;
                if (chekStep(Labirint, StepsInLabirint, tempYX, Memory, Ochered)) {
                    StepsInLabirint[tempYX[1]][tempYX[0]] = StepsInLabirint[tempYX[1] + 1][tempYX[0]] + 1;
                }
                tempYX[1] += 1;
            }
        }
        System.out.println(0);
        return;
    }
    
    public static boolean chekStep(int[][] Labirint, int[][] StepsInLabirint, int[] tempYX, Queue<int[]> Memory, Queue<int[]> Ochered) {
        if ((Labirint[tempYX[1]][tempYX[0]] == 0 || Labirint[tempYX[1]][tempYX[0]] == 2) && notConteins(Memory, tempYX)) {
            Ochered.add(tempYX.clone());
            Memory.add(tempYX.clone());
            return true;
        }
        return false;
    }

    public static boolean notConteins(Queue<int[]> Memory, int[] tempYX) {
        for (int[] mem : Memory) {
            if (mem[0] == tempYX[0] && mem[1] == tempYX[1]) {
                return false;
            }
        }
        return true;
    }

}