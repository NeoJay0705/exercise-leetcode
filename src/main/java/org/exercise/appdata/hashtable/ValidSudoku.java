package org.exercise.appdata.hashtable;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 36
// can improve

public class ValidSudoku {
    public static void main(String[] args) {
        ValidSudoku vs = new ValidSudoku();
        vs.isValidSudoku(new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','2','.','1','9','5','.','.','.'},{'.','2','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}});
    }

    public String dod(String s) {
        return s;
    }

    public boolean isValidSudoku(char[][] board) {
        List<Map<Character, Integer>> infos = new ArrayList<>(9);
        for ( int i = 0; i < board.length; ++i ) {
            Map<Character, Integer> rowInfo = new HashMap<>();
            for ( int j = 0; j < board[0].length; ++j ) {
                if ( rowInfo.containsKey(board[i][j]) ) return false;
                if ( board[i][j] != '.' ) rowInfo.put(board[i][j], j);
            }
            infos.add(rowInfo);
        }

        for ( int i = 0; i < board.length; ++i ) {
            for ( int j = 0; j < board[0].length; ++j ) {
                if ( board[i][j] != '.' ) {
                    int count = 0;
                    for ( Map<Character, Integer> info : infos ) {
                        Integer colNum = info.get(board[i][j]);
                        if ( colNum != null && count != i ) {
                            if ( colNum.intValue() == j ) return false;
                            if ( colNum.intValue() / 3 == j / 3 && count / 3 == i / 3 ) return false;
                        }
                        count++;
                    }
                }
            }
        }

        return true;
    }
}
