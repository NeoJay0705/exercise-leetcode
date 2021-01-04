package org.exercise.algo.dfs;

import java.util.Deque;
import java.util.LinkedList;

// 200
// 10% Can improve

public class NumberofIslands {
    public static void main(String[] args) {
        NumberofIslands noi = new NumberofIslands();
        char[][][] inputs = new char[][][] {
                                                {
                                                    {'1','1','1','1','0'},
                                                    {'0','0','1','0','1'},
                                                    {'1','0','1','1','1'},
                                                    {'1','1','1','0','0'},
                                                    {'0','0','0','0','1'},
                                                },
                                            };
        for ( char[][] input : inputs ) {
            System.out.println(noi.numIslands(input));
        }
    }

    public int numIslands(char[][] grid) {
        int count = 0;

        for ( int i = 0; i < grid.length; i++ ) {
            for ( int j = 0; j < grid[0].length; j++ ) {
                if ( grid[i][j] == '1' ) {
                    count += dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public int dfs(char[][] grid, int row, int col) {
        grid[row][col] = '0';
        if ( row - 1 > -1 && grid[row - 1][col] == '1' ) dfs(grid, row - 1, col);
        if ( row + 1 < grid.length && grid[row + 1][col] == '1' ) dfs(grid, row + 1, col);
        if ( col - 1 > -1 && grid[row][col - 1] == '1' ) dfs(grid, row, col - 1);
        if ( col + 1 < grid[0].length && grid[row][col + 1] == '1' ) dfs(grid, row, col + 1);
        return 1;
    }
}
