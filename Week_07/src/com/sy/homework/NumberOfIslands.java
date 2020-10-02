package com.sy.homework;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int rows,cols;
        if(grid==null || (rows=grid.length)==0 || (cols=grid[0].length)==0){
            return 0;
        }
        int count = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j,rows,cols);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j, int rows, int cols) {
        if(i>=0 && i<rows && j>=0 && j<cols && grid[i][j]=='1'){
            grid[i][j]='0';
            dfs(grid,i,j+1,rows,cols);
            dfs(grid,i+1,j,rows,cols);
            dfs(grid,i,j-1,rows,cols);
            dfs(grid,i-1,j,rows,cols);
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(new NumberOfIslands().numIslands(grid));
    }
}
