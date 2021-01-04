package org.exercise.array;

import java.util.List;

// 118

public class PascalsTriangleII {
    public static void main(String[] args) {
        PascalsTriangleII ptii = new PascalsTriangleII();
        int[] inputs = new int[] { 0, 1, 2, 3, 4, 5, 6};

        for ( int i : inputs ) {
            for ( int j : ptii.getRow(i) ) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public List<Integer> getRow(int rowIndex) {
        PascalsTriangle pt = new PascalsTriangle();
        return pt.generate(rowIndex + 1).get(rowIndex);
    }
}
