package Task2;
// Не работает
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(); // высота
        int M = scan.nextInt(); // ширина

        int[] x1y1 = new int[2];
        for (int i =0; i<2; i++) {
            x1y1[i] = scan.nextInt();
        }

        Integer[] x2y2 = new Integer[2];
        for (int i =0; i<2; i++) {
            x2y2[i] = scan.nextInt();
        }

        int[][] Labirint =new int[N][M];
        for (int i = 0; i<N; i++) {
            for (int j =0; j<M; j++) {
                Labirint[i][j] = scan.nextInt();
            }
        }
        int[][] StepsInLabirint = new int[N][M];
        StepsInLabirint[x1y1[1]][x1y1[0]] = 0;
        scan.close();
        Labirint[x2y2[1]][x2y2[0]] = 2;     // X и Y наоборот идут!!!
        Queue<int[]> Ochered = new LinkedList<int[]>();
        Set<String> Memory = new HashSet<String>(N*M);
        Ochered.add(x1y1);
        Integer X1 = x1y1[0];
        Integer Y1 = x2y2[1];
        Memory.add(X1.toString()+Y1.toString());
        
        while (!Ochered.isEmpty()) {
            int[] tempYX = Ochered.poll().clone();
            Integer Y = tempYX[1];
            Integer X = tempYX[0];
            if (Labirint[Y][X] == 2) { //Если выход нашелся
                System.out.println(StepsInLabirint[Y][X]);
                return;
            }
            
            if (X - 1 >= 0) {
                X -= 1;
                if ((Labirint[Y][X] == 0 || Labirint[Y][X] == 2)  && !Memory.contains(X.toString()+Y.toString())) {
                    Ochered.add(tempYX.clone());
                    Memory.add(X.toString()+Y.toString());
                    StepsInLabirint[Y][X] = StepsInLabirint[Y][X + 1] + 1;
                }
                X += 1;
            }

            if (X + 1 < M) {
                X += 1;
                if ((Labirint[Y][X] == 0 || Labirint[Y][X] == 2) && !Memory.contains(X.toString()+Y.toString())) {
                    Ochered.add(tempYX.clone());
                    Memory.add(X.toString()+Y.toString());
                    StepsInLabirint[Y][X] = StepsInLabirint[Y][X - 1] + 1;
                }
                X -= 1;
            }
            
            if (Y + 1 < N) {
                Y += 1;
                if ((Labirint[Y][X] == 0 || Labirint[Y][X] == 2)  && !Memory.contains(X.toString()+Y.toString())) {
                    Ochered.add(tempYX.clone());
                    Memory.add(X.toString()+Y.toString());
                    StepsInLabirint[Y][X] = StepsInLabirint[Y - 1][X] + 1;
                }
                Y -= 1;
            }

            if (Y- 1 >=0 ) {
                Y -= 1;
                if ((Labirint[Y][X] == 0 || Labirint[Y][X] == 2) && !Memory.contains(X.toString()+Y.toString())) {
                    Ochered.add(tempYX.clone());
                    Memory.add(X.toString()+Y.toString());
                    StepsInLabirint[Y][X] = StepsInLabirint[Y + 1][X] + 1;
                }
                Y += 1;
            }
        }
        System.out.println(0);
        return;
    }
}
