package Tresh;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(); // высота
        int M = scan.nextInt(); // ширина
        int x1 = scan.nextInt(); // координата старта
        int y1 = scan.nextInt();
        int x2 = scan.nextInt(); // координата выхода
        int y2 = scan.nextInt();
        int steps =0;
        int[][] Labirint =new int[N][M];
        for (int i = 0; i<N; i++) {
            for (int j =0; j<M; j++) {
                Labirint[i][j] = scan.nextInt();
            }
        }
        scan.close();
        Integer [] Start = {x1,y1};
        Labirint[x2][y2] = 2;
        Queue<Integer[]> AnalizKletok = new LinkedList<Integer[]>();
        Queue<Integer[]> Memory = new LinkedList<Integer[]>();
        AnalizKletok.add(Start);
        Memory.add(Start);
        while(true) {
            Integer[] Current = AnalizKletok.poll();
            steps++;
            if (Labirint[Current[0]][Current[1]] == 2) {
                break;
            }
            if (Current[0] + 1 < N) {
                if (Labirint[Current[0]+1][Current[1]] == 0) {  
                    Current[0]+=1;
                    if (!Memory.contains(Current)) {
                        AnalizKletok.add(Current);
                    }
                    Current[0]-=1;
                }
            }
            if (Current[0] - 1 >= 0) {
                if (Labirint[Current[0]-1][Current[1]] == 0) {
                    Current[0]-= 1;
                    if (!Memory.contains(Current)) {
                        AnalizKletok.add(Current);
                    }
                    Current[0]+= 1;
                }
            }
            if (Current[1] + 1 < M) {
                if (Labirint[Current[0]][Current[1]+1] == 0) {
                    Current[1]+= 1;
                    if (!Memory.contains(Current)) {
                        AnalizKletok.add(Current);
                    }
                    Current[1]-= 1;
                }
            }
            if (Current[1] - 1 >= 0) {
                if (Labirint[Current[0]][Current[1] - 1] == 0 ) {
                    Current[1]-= 1;
                    if (!Memory.contains(Current)) {
                        AnalizKletok.add(Current);
                    }
                    Current[1]+= 1;
                }
            }
            
            if (AnalizKletok.size() == 0) {
                System.out.println(0);
            }
        }
        System.out.println(steps);
    }
}
