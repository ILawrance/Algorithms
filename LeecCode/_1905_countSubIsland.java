package ProblemsLeetCode;

import java.util.ArrayList;

public class _1905_countSubIsland {
    public static void main(String[] args) {
        int[][] grid1 = new int[][]{{1,1,1,0,0},{0,1,1,1,1},{0,0,0,0,0},{1,0,0,0,0},{1,1,0,1,1}};
        int[][] grid2 = new int[][]{{1,1,1,0,0},{0,0,1,1,1},{0,1,0,0,0},{1,0,1,1,0},{0,1,0,1,0}};
        int[][] grid3 = new int[][]{{1,0,1},{0,0,0},{1,1,1}};
        int[][] grid4 = new int[][]{{1,1,1},{0,0,0},{1,1,1}};
        System.out.println( countSubIslands(grid1, grid2));
    }
    public static int countSubIslands(int[][] grid1, int[][] grid2) {
        int countFirst = 0;
        int countSecond = 0;
        int count = 0;
        ArrayList<ArrayList<Integer[]>> arrIslands1 = new ArrayList<>();
        ArrayList<ArrayList<Integer[]>> arrIslands2 = new ArrayList<>();
        int[][] mergedGrid = new int[grid1.length][grid1[0].length];
        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[0].length; j++) {
                if (grid1[i][j] == 1) {
                    countFirst++;
                    bfsIslands(grid1, i, j, arrIslands1, countFirst);
                }
            }
        }
        return count;
    }

    public static void bfsIslands(int[][] grid, int i, int j, ArrayList<ArrayList<Integer[]>> arrIslands, int count) {
        int m = grid.length;
        int n = grid[0].length;

        if ( i < 0 || j < 0 || i >= m || j >= n  || grid[i][j] == 0) {
            return;
        }

        if (arrIslands.get(count) != null) {
            arrIslands.get(count).add(new Integer[]{i, j});
        }
        else {
            arrIslands.add(new ArrayList<Integer[]>());
            arrIslands.get(count).add(new Integer[]{i, j});
        }

        bfsIslands(grid, i + 1, j, arrIslands, count);
        bfsIslands(grid, i - 1, j, arrIslands, count);
        bfsIslands(grid, i, j + 1, arrIslands, count);
        bfsIslands(grid, i, j - 1, arrIslands, count);
    }

    public static void bfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n  || grid[i][j] == 0) {
            return;
        }
        bfs(grid, i + 1, j);
        bfs(grid, i - 1, j);
        bfs(grid, i, j + 1);
        bfs(grid, i, j - 1);
    }
}
