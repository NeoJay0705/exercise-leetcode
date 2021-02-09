package org.exercise.algo.recursive;

// 48

public class RotateImage {
    public void rotate(int[][] matrix) {
        degrade(matrix, 0, matrix.length - 1);
    }

    public int[][] degrade(int[][] matrix, int start, int end) {
        if ( start > end ) return matrix;

        for ( int i = 0; i < end - start; ++i ) {
            int tmp = matrix[start + i][end];
            matrix[start + i][end] = matrix[start][start + i];
            int tmp2 = matrix[end][end - i];
            matrix[end][end - i] = tmp;
            tmp = tmp2;
            tmp2 = matrix[end - i][start];
            matrix[end - i][start] = tmp;
            matrix[start][start + i] = tmp2;
        }

        return degrade(matrix, start + 1, end - 1);
    }
}
