package org.exercise.array;

import java.util.ArrayList;
import java.util.List;

// 118

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) return new ArrayList<>();
        
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);

        for (int i = 2; i <= numRows; ++i) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            row.add(1);
            int inner = i - 2;
            for (int j = 0; j < inner; ++j) {
                int sum = result.get(i - 2).get(j) + result.get(i - 2).get(j + 1);
                row.add(j + 1, sum);
            }
            result.add(row);
        }

        return result;
    }
}
