package ProblemsLeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class _200V2_NumberOfIslands {public static void main(String[] args) {
    char[][] test1 = new char[][]{{'1','0','1','1','0','1','1'}};
    char[][] test2 = new char[][]{
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}};

    int ans = numIslands(test2);

    System.out.println(ans);
}

    public static int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                    grid[i][j] = Character.forDigit(count, 10);

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int x = cur[0];
                        int y = cur[1];

                        for (int[] direction : directions) {
                            int newX = x + direction[0];
                            int newY = y + direction[1];

                            if (newX < grid.length &&
                                    newY < grid[0].length &&
                                    newX > -1 &&
                                    newY > -1 &&
                                    grid[newX][newY] == '1' &&
                                    !visited[newX][newY]) {
                                visited[newX][newY] = true;
                                q.add(new int[]{newX, newY});
                                grid[newX][newY] =Character.forDigit(count, 10);
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println(" ");
        }
        return count;
    }
}
