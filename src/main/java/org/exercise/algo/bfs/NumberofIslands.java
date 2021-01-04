package org.exercise.algo.bfs;

import java.util.Deque;
import java.util.LinkedList;

// 200
// 10% Can improve

public class NumberofIslands {
    private class Position {
        int x;
        int y;
        Position(int x, int y) { this.x = x; this.y = y;}
    }

    public static void main(String[] args) {
        NumberofIslands noi = new NumberofIslands();
        char[][][] inputs = new char[][][] {
                                                {
                                                    {'1','1','1'},
                                                    {'0','1','0'},
                                                    {'1','1','1'}
                                                },
                                            };
        for ( char[][] input : inputs ) {
            System.out.println(noi.numIslands(input));
        }
    }

    public int numIslands(char[][] grid) {
        boolean[][] isVisted = new boolean[grid.length][grid[0].length];
        Deque<Position> queue = new LinkedList<>();
        int count = 0;

        for ( int i = 0; i < isVisted.length; ++i ) {
            for ( int j = 0; j < isVisted[0].length; ++j ) {
                if ( !isVisted[i][j] ) {
                    isVisted[i][j] = true;
                    if ( grid[i][j] == '1' ) queue.offerLast(new Position(i, j));
                    while ( !queue.isEmpty() ) {
                        Position inQ = queue.pollFirst();
                        int tmpI = inQ.x;
                        int tmpJ = inQ.y;
                        isVisted[tmpI][tmpJ] = true;
                        if ( tmpI - 1 > -1 && !isVisted[tmpI - 1][tmpJ] ) {
                            if (grid[tmpI - 1][tmpJ] == '1') queue.offerLast(new Position(tmpI - 1, tmpJ));
                            isVisted[tmpI - 1][tmpJ] = true;
                        }
                        if ( tmpI + 1 < isVisted.length && !isVisted[tmpI + 1][tmpJ] ) {
                            if(grid[tmpI + 1][tmpJ] == '1') queue.offerLast(new Position(tmpI + 1, tmpJ));
                            isVisted[tmpI + 1][tmpJ] = true;
                        }
                        if ( tmpJ + 1 < isVisted[0].length && !isVisted[tmpI][tmpJ + 1] ) {
                            if (grid[tmpI][tmpJ + 1] == '1') queue.offerLast(new Position(tmpI, tmpJ + 1));
                            isVisted[tmpI][tmpJ + 1] = true;
                        }
                        if ( tmpJ - 1 > -1 && !isVisted[tmpI][tmpJ - 1] ) {
                            if (grid[tmpI][tmpJ - 1] == '1') queue.offerLast(new Position(tmpI, tmpJ - 1));
                            isVisted[tmpI][tmpJ - 1] = true;
                        }
                        if ( queue.isEmpty() ) count++;
                    }
                }
            }
        }
        return count;
    }
}
