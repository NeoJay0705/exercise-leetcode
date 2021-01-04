package org.exercise.array;

import java.util.ArrayList;
import java.util.List;

// 498
// Draw your idea and move it step by step

public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0] == null ) return new int[0];

        int numOfTraversed = 0;
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int total = rowLen * colLen;
        int[] result = new int[total];
        boolean rightTop = true;
        int curI = 0;
        int curJ = 0;

        while ( numOfTraversed < total ) {
            if ( rightTop ) {
                while ( curI >= 0 && curJ < colLen ) {
                    result[numOfTraversed] = matrix[curI][curJ];
                    curI--;
                    curJ++;
                    numOfTraversed++;
                }
                
                if ( curJ == colLen  ) {
                    curI++;
                    curJ--;
                }
                curI++;
            }
            else {
                while ( curI < rowLen && curJ >= 0 ) {
                    result[numOfTraversed] = matrix[curI][curJ];
                    curI++;
                    curJ--;
                    numOfTraversed++;
                }
                
                if ( curI == rowLen  ) {
                    curJ++;
                    curI--;
                }
                curJ++;
            }
            rightTop = !rightTop;
        }

        return result;
    }
}
