package org.exercise.algo.dfs;

// 50

public class Powxn {
    public double myPow(double x, int n) {
        double splition;
        if ( n == 0 ) return 1;

        splition = myPow(x, n / 2);

        if ( n % 2 == 0 ) return splition * splition;
        else {
            if ( n > 0 ) return x * splition * splition;
            else return splition * splition / x;
        }
    }
}
