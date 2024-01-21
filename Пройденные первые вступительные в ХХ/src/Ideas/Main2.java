package Tresh;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(); // высота
        int M = scan.nextInt(); // ширина
        Integer[] x1y1 = new Integer[2];
        for (Integer i =0; i<2; i++) {
            x1y1[i] = scan.nextInt();
        }
        Integer[] x2y2 = new Integer[2];
        for (Integer i=0; i<2; i++) {
            x2y2[i] = scan.nextInt();
        }
        int steps =0;
        int[][] Labirint =new int[N][M];
        for (int i = 0; i<N; i++) {
            for (int j =0; j<M; j++) {
                Labirint[i][j] = scan.nextInt();
            }
        }
        scan.close();
        Labirint[x2y2[0]][x2y2[1]] = 2;
        Queue<Integer[]> Ochered = new LinkedList<Integer[]>();
        Queue<Integer[]> Memory = new LinkedList<Integer[]>();
        Ochered.add(x1y1);
        Memory.add(x1y1);
        Integer[] tempXY = new Integer[2];
        
        while (!Ochered.isEmpty()) {
            Integer[] clone = Ochered.poll();
            tempXY[0] = clone[0].intValue();
            tempXY[1] = clone[1].intValue();

          
            System.out.println("Do preobrazovanii " + tempXY[0] + " , " + tempXY[1]);
            steps++;
            if (Labirint[tempXY[0]][tempXY[1]] == 2) {
                System.out.println(steps);
                return;
            }
            if (tempXY[0]-1 >= 0) {
                tempXY[0] -= 1;
                int [] tempTempXY = {tempXY[0].intValue(), tempXY[1].intValue()};
                if (Labirint[tempXY[0]][tempXY[1]] == 0 && !isConteins2(Memory, tempTempXY)) {
                    Ochered.add(tempXY);
                    Memory.add(tempXY);
                }
                tempXY[0] +=1;
            }
            if (tempXY[0]+1 < N) {
                tempXY[0] += 1;
                int [] tempTempXY = {tempXY[0].intValue(), tempXY[1].intValue()};
                System.out.println("Posle Preobrazovanii " + tempXY[0] + ", " + tempXY[1]);
                System.out.println("Integer in tempXY :");
                for (Integer integer : tempXY) {
                    System.out.println(integer);
                }
                System.out.println("Integer in memory: ");
                for (Integer[] integer : Memory) {
                    System.out.println(integer[0] + " " + integer[1]);
                }

                if (Labirint[tempXY[0]][tempXY[1]] == 0 && !isConteins2(Memory, tempTempXY)) {
                    Ochered.add(tempXY);
                    Memory.add(tempXY);
                }
                tempXY[0] -= 1;
            }
            if (tempXY[1]-1 >= 0) {
                tempXY[1] -= 1;
                int [] tempTempXY = {tempXY[0].intValue(), tempXY[1].intValue()};
                if (Labirint[tempXY[0]][tempXY[1]] == 0 && !isConteins2(Memory, tempTempXY)) {
                    Ochered.add(tempXY);
                    Memory.add(tempXY);
                }
                tempXY[1] +=1;
            }
            if (tempXY[1]+1 < M) {
                tempXY[1] += 1;
                int [] tempTempXY = {tempXY[0].intValue(), tempXY[1].intValue()};
                if (Labirint[tempXY[0]][tempXY[1]] == 0 && !isConteins2(Memory, tempTempXY))  {
                    Ochered.add(tempXY);
                    Memory.add(tempXY);
                }
                tempXY[1] -= 1;
            }
        }
        System.out.println(0);
        return;
    }
    public static boolean isConteins2(Queue<Integer[]> Memory, int [] tempTempXY) { 
        for (Integer[] Mem : Memory) {
            if (Mem[0].intValue() == tempTempXY[0] && Mem[1].intValue() == tempTempXY[1]) {
                return true;
            }
        }
        return false;
    }
}

// && !Memory.contains(tempXY)