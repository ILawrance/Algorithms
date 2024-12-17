package ProblemsLeetCode;

public class _130V2_SurroundedRegions {
    public static void main(String[] args) {

    }
    public void dfs(char[][] grid,int i,int j){
        if(i<0 || j<0 ||i>=grid.length || j>=grid[0].length || grid[i][j]=='#' || grid[i][j]=='X'){
            return;
        }
        grid[i][j]='#';
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
    public void solve(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='O'){
                    if(i==0 || j==0 || i==n-1  || j==m-1 ){
                        dfs(grid,i,j);
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='O'){
                    grid[i][j]='X';
                }else if(grid[i][j]=='#'){
                    grid[i][j]='O';
                }
            }
        }
    }
}
