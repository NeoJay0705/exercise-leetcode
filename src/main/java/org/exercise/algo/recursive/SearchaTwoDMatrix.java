package org.exercise.algo.recursive;

// 74

public class SearchaTwoDMatrix {
    public static void main(String[] args) {
        SearchaTwoDMatrix s = new SearchaTwoDMatrix();
        System.out.println(s.searchMatrix(new int[][]{{1},{3}}, 3));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int candRow = selectRow(0, rows - 1, matrix, target);
        return search(matrix[candRow], target, 0, cols - 1);
    }

    public int selectRow(int s, int e, int[][] matrix, int target) {
        if ( e < 0 ) return 0;
        else if ( s == matrix.length ) return matrix.length - 1;

        int mid = (s + e) / 2;
        if ( target < matrix[mid][0] ) return selectRow(s, mid - 1, matrix, target);

        if ( mid + 1 < matrix.length ) {
            if ( target < matrix[mid + 1][0] && target >= matrix[mid][0] ) return mid;
            else {
                return selectRow(mid + 1, e, matrix, target);
            }
        }
        else return matrix.length - 1;
    }

    public boolean search(int[] matrix, int target, int s, int e) {
        if ( e < s ) return false;

        int mid = (s + e) / 2;
        if ( matrix[mid] == target ) return true;
        else if ( target < matrix[mid] ) {
            return search(matrix, target, s, mid - 1);
        }
        else {
            return search(matrix, target, mid + 1, e);
        }
    }
}
