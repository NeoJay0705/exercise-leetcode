package org.exercise.algo.recursive;

public class KthSymbolinGrammar {
    public int kthGrammar(int N, int K) {
        StringBuilder sb = new StringBuilder("0");
        for ( int i = 0; i < N; ++i ) {
            StringBuilder newSub = new StringBuilder();
            for ( int j = 0; j < sb.length(); ++j ) {
                newSub.append(sb.charAt(j) == '0' ? "01" : "10");
            }
            sb = newSub;
        }
        return sb.charAt(K - 1) - '0';
    }

    public int kthGrammar_rec(int N, int K) {
        String str = helper("0", 1, N);
        return str.charAt(K - 1) - '0';
    }

    public String helper(String str, int count, int n) {
        if ( count > n ) return str;

        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < str.length(); ++i ) {
            sb.append(str.charAt(i) == '0' ? "01" : "10");
        }
        return helper(sb.toString(), count + 1, n);
    }
}
