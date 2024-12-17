package ProblemsLeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _130_SurroundedRegions {
    public static void main(String[] args) {
        surroundedRegions(new char[][]
                {{'O','O','O','O','O','O','O','O','X','O','O','O','O','O','X','O','O','O','O','O'}, // 0
                {'O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','O'}, // 1
                {'X','O','O','X','O','X','O','O','O','O','X','O','O','X','O','O','O','O','O','O'}, // 2
                {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','X','X','O'}, // 3
                {'O','X','X','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O'}, // 4
                {'O','O','O','O','X','O','O','O','O','O','O','X','O','O','O','O','O','X','X','O'}, // 5
                {'O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','O'}, // 6
                {'O','O','O','O','O','O','O','O','O','O','O','O','O','X','O','O','O','O','O','O'}, // 7
                {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','X','O'}, // 8
                {'O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','O','O','O'}, // 9
                {'O','O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O'}, // 10
                {'O','O','O','O','X','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O'}, //11,
                {'O','O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O'}, // 12
                {'X','O','O','O','O','O','O','O','O','X','X','O','O','O','O','O','O','O','O','O'}, // 13
                {'O','O','O','O','O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O'}, // 14
                {'O','O','O','O','X','O','O','O','O','O','O','O','O','X','O','O','O','O','O','X'}, // 15
                {'O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','X','O','X','O','O'}, // 16
                {'O','X','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'}, // 17
                {'O','O','O','O','O','O','O','O','X','X','O','O','O','X','O','O','X','O','O','X'}, // 18
                {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'}}); // 19
                }//0  1   2   3   4   5   6   7   8   9   10  11  12  13 14  15   16  17  18  19

    public static void surroundedRegions(char[][] board) {
        boolean isEarth = false;
        ArrayList<int[]> forChange = new ArrayList<>();
        boolean[][] passed = new boolean[board.length][board[0].length];
        int[][] directions  = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O' && !passed[i][j]) {
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    passed[i][j] = true;

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        forChange.add(cur);

                        for (int[] direction : directions) {
                            if (((cur[0] + direction[0] < board.length) &&
                                    (cur[0] + direction[0] >= 0)) &&
                                    cur[1] + direction[1] < board[i].length &&
                                    (cur[1] + direction[1] >= 0)) {
                                if (board[cur[0] + direction[0]][cur[1] + direction[1]] == 'O' &&
                                        !passed[cur[0]+direction[0]][cur[1] + direction[1]]) {
                                    q.offer(new int[]{cur[0] + direction[0], cur[1] + direction[1]});
                                    passed[cur[0] + direction[0]][cur[1] + direction[1]] = true;
                                }
                            }
                            else isEarth = true;
                        }
                    }
                    if (!isEarth) {
                        for(int[] cur : forChange) {
                            board[cur[0]][cur[1]] = 'X';
                        }
                    }
                    isEarth = false;
                    forChange.clear();
                }
            }
        }
        for (char[] place : board) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(place[j] + " ");
            }
        }
    }
}
