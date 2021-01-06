package org.exercise.algo.dfs;

import java.time.ZoneId;

public class ZOMetrix {
    public static void main(String[] args) {
        ZOMetrix zom = new ZOMetrix();
        int[][][] inputs = new int[][][] {
                                            {
                                                {0,0,0},
                                                {0,1,0},
                                                {0,0,0}
                                            },
                                            {
                                                {0,0,0},
                                                {0,1,0},
                                                {1,1,1}
                                            }
                                         };
        for ( int[][] input : inputs ) {
            int[][] result = zom.updateMatrix(input);
            for ( int[] row : result ) {
                for ( int col : row ) {
                    System.out.print(col + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public int[][] updateMatrix(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        
        for ( int i = 0; i < matrix.length; ++i ) {
            for ( int j = 0; j < matrix[0].length; ++j ) {
                int minDistance = Integer.MAX_VALUE;
                boolean[][] isVisted = new boolean[matrix.length][matrix[0].length];
                minDistance = Math.min(minDistance, dfsRD(matrix, i, j, isVisted));
                isVisted = new boolean[matrix.length][matrix[0].length];
                minDistance = Math.min(minDistance, dfsDL(matrix, i, j, isVisted));
                isVisted = new boolean[matrix.length][matrix[0].length];
                minDistance = Math.min(minDistance, dfsLU(matrix, i, j, isVisted));
                isVisted = new boolean[matrix.length][matrix[0].length];
                minDistance = Math.min(minDistance, dfsUR(matrix, i, j, isVisted));
                result[i][j] = minDistance - i - j < 0 ? -(minDistance - i - j) : minDistance - i - j;
            }
        }

        return result;
    }

    public int dfsRD(int[][] matrix, int i, int j, boolean[][] isVisted) {
        isVisted[i][j] = true;
        if ( matrix[i][j] == 0 ) return i + j;

        int r = Integer.MAX_VALUE, d = Integer.MAX_VALUE;
        if ( j + 1 < matrix[0].length && !isVisted[i][j + 1] ) r = dfsRD(matrix, i, j + 1, isVisted);
        if ( i + 1 < matrix.length && !isVisted[i + 1][j] ) d = dfsRD(matrix, i + 1, j, isVisted);
        return Math.min(r, d);
    }

    public int dfsDL(int[][] matrix, int i, int j, boolean[][] isVisted) {
        isVisted[i][j] = true;
        if ( matrix[i][j] == 0 ) return i + j;

        int d = Integer.MAX_VALUE, l = Integer.MAX_VALUE;
        if ( i + 1 < matrix.length && !isVisted[i + 1][j] ) l = dfsRD(matrix, i + 1, j, isVisted);
        if ( j - 1 > -1 && !isVisted[i][j - 1] ) d = dfsRD(matrix, i, j - 1, isVisted);
        return Math.min(d, l);
    }

    public int dfsLU(int[][] matrix, int i, int j, boolean[][] isVisted) {
        isVisted[i][j] = true;
        if ( matrix[i][j] == 0 ) return i + j;

        int l = Integer.MAX_VALUE, u = Integer.MAX_VALUE;
        if ( j - 1 > -1 && !isVisted[i][j - 1] ) l = dfsRD(matrix, i, j - 1, isVisted);
        if ( i - 1 > -1 && !isVisted[i - 1][j] ) u = dfsRD(matrix, i - 1, j, isVisted);
        return Math.min(l, u);
    }

    public int dfsUR(int[][] matrix, int i, int j, boolean[][] isVisted) {
        isVisted[i][j] = true;
        if ( matrix[i][j] == 0 ) return i + j;

        int u = Integer.MAX_VALUE, r = Integer.MAX_VALUE;
        if ( i - 1 > -1 && !isVisted[i - 1][j] ) u = dfsRD(matrix, i - 1, j, isVisted);
        if ( j + 1 < matrix[0].length && !isVisted[i][j + 1] ) r = dfsRD(matrix, i, j + 1, isVisted);
        return Math.min(u, r);
    }
}
