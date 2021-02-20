package org.exercise.algo.dfs;

// 79

public class WordSearch {
    public static void main(String[] args) {
        WordSearch ws = new WordSearch();
        char[][][] inputs = new char[][][] {
            {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},
            {{'B'}}
        };
        String[] words = new String[] {
            "BCCEDFS",
            "C"
        };

        for ( int i = 0; i < inputs.length; ++i ) {
            System.out.println(ws.exist(inputs[i], words[i]));
        }
    }
    public boolean exist(char[][] board, String word) {
        boolean existed = false;
        for ( int i = 0; i < board.length && !existed; ++i ) {
            for ( int j = 0; j < board[0].length && !existed; ++j ) {
                if ( board[i][j] == word.charAt(0) ) existed = helper(i, j, board, word, 0);
            }
        }

        return existed;
    }

    public boolean helper(int i, int j, char[][] board, String word, int k) {
        char memo = board[i][j];
        board[i][j] = '-';
        if ( memo != word.charAt(k) ) {
            board[i][j] = memo;
            return false;
        } 
        else if ( k == word.length() - 1 ) {
            board[i][j] = memo;
            return true;
        }

        boolean existed = false;
        if ( i - 1 > -1 ) existed = helper(i - 1, j, board, word, k + 1);
        if ( j + 1 < board[0].length && !existed ) existed = helper(i, j + 1, board, word, k + 1);
        if ( i + 1 < board.length && !existed ) existed = helper(i + 1, j, board, word, k + 1);
        if ( j - 1 > -1 && !existed ) existed = helper(i, j - 1, board, word, k + 1);

        board[i][j] = memo;
        return existed;
    }
}
