package Task2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;



public class MainSYacheikoi{
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

        
        int[][] StepsInLabirint = new int[N][M];
        StepsInLabirint[x1y1[1]][x1y1[0]] = 0;
        Labirint[x2y2[1]][x2y2[1]] = 2;       // X и Y наоборот идут!

        Queue<Yacheika> Ochered = new LinkedList<Yacheika>();
        Set<Yacheika> Memory = new HashSet<Yacheika>();
        Yacheika first = new Yacheika(x1y1[0], x1y1[1]);
        Ochered.add(first);
        Memory.add(first);

        while (!Ochered.isEmpty()) {
            Yacheika step = Ochered.poll();
            
            if (Labirint[step.y][step.x] == 2) {                               // Если выход нашелся
                System.out.println(StepsInLabirint[step.y][step.x]);
                return;
            }
            
            if (step.x - 1 >= 0) {                                              // Шаг влево
                step.x -= 1;
                if ((Labirint[step.y][step.x] == 0 || Labirint[step.y][step.x] == 2)  && !Memory.contains(step)) {
                    Yacheika tempYacheika = new Yacheika(step.x, step.y);
                    Ochered.add(tempYacheika);
                    Memory.add(tempYacheika);
                    StepsInLabirint[step.y][step.x] = StepsInLabirint[step.y][step.x + 1] + 1;
                }
                step.x += 1;
            }

            if (step.x + 1 < M) {                                                // Шаг вправо
                step.x += 1;
                if ((Labirint[step.y][step.x] == 0 || Labirint[step.y][step.x] == 2) && !Memory.contains(step)) {
                    Yacheika tempYacheika = new Yacheika(step.x, step.y);
                    Ochered.add(tempYacheika);
                    Memory.add(tempYacheika);
                    StepsInLabirint[step.y][step.x] = StepsInLabirint[step.y][step.x-1] + 1;
                }
                step.x -= 1;
            }
            
            if (step.y + 1 < N) {                                                // Шаг вниз
                step.y += 1;
                if ((Labirint[step.y][step.x] == 0 || Labirint[step.y][step.x] == 2)  && !Memory.contains(step)) {
                    Yacheika tempYacheika = new Yacheika(step.x, step.y);
                    Ochered.add(tempYacheika);
                    Memory.add(tempYacheika);
                    StepsInLabirint[step.y][step.x] = StepsInLabirint[step.y-1][step.x] + 1;
                }
                step.y -= 1;
            }

            if (step.y - 1 >=0 ) {                                               // Шаг вверх
                step.y -= 1;
                if ((Labirint[step.y][step.x] == 0 || Labirint[step.y][step.x] == 2) && !Memory.contains(step)) {
                    Yacheika tempYacheika = new Yacheika(step.x, step.y);
                    Ochered.add(tempYacheika);
                    Memory.add(tempYacheika);
                    StepsInLabirint[step.y][step.x] = StepsInLabirint[step.y + 1][step.x] + 1;
                }
                step.y += 1;
            }
        }
    }
}

class Yacheika {
    public int x;
    public int y;
    Yacheika(int x, int y) {
        this.x = x; 
        this.y = y;
    }
}
