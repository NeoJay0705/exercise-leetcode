package org.exercise.array;

import java.util.ArrayList;
import java.util.List;

// 54

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while ( top <= bottom && left <= right ) {
            for ( int j = left; j <= right && top <= bottom; ++j ) {
                result.add(matrix[top][j]);
            }
            ++top;
            
            for ( int i = top; i <= bottom && left <= right; ++i ) {
                result.add(matrix[i][right]);
            }
            --right;
    
            for ( int j = right; j >= left && top <= bottom; --j ) {
                result.add(matrix[bottom][j]);
            }
            --bottom;
    
            for ( int i = bottom; i >= top && left <= right; --i ) {
                result.add(matrix[i][left]);
            }
            ++left;
        }
        
        return result;
    }
}
