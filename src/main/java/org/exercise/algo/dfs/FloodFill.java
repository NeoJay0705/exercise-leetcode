package org.exercise.algo.dfs;

// 733

public class FloodFill {
    public static void main(String[] args) {
        FloodFill ff = new FloodFill();
        int[][][] inputs = new int[][][]{
                                            {
                                                {1,1,1},
                                                {1,1,0},
                                                {1,0,1},
                                            },
                                            {
                                                {1}
                                            },
                                            {
                                                {0,0,0},
                                                {0,1,1}
                                            }
                                        };
        int[][] corInputs = new int[][]{
                                            {1,1,2},  
                                            {0,0,3},
                                            {1,1,1}   
                                       };
        for ( int i = 0; i < inputs.length; ++i ) {
            int[][] result = ff.floodFill(inputs[i], corInputs[i][0], corInputs[i][1], corInputs[i][2]);
            for ( int[] row : result ) {
                for ( int col : row ) {
                    System.out.print(col + " ");
                }
                System.out.println();
            }
            System.out.println("-----");
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean[][] isVisted = new boolean[image.length][image[0].length];
        dfs(image, sr, sc, newColor, image[sr][sc], isVisted);
        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int newColor, int originColor, boolean[][] isVisted) {
        isVisted[sr][sc] = true;
        if ( image[sr][sc] == originColor ) image[sr][sc] = newColor;
        if ( sr - 1 > -1 && isVisted[sr - 1][sc] == false && image[sr - 1][sc] == originColor ) dfs(image, sr - 1, sc, newColor, originColor, isVisted);
        if ( sr + 1 < image.length && isVisted[sr + 1][sc] == false && image[sr + 1][sc] == originColor ) dfs(image, sr + 1, sc, newColor, originColor, isVisted);
        if ( sc - 1 > -1 && isVisted[sr][sc - 1] == false && image[sr][sc - 1] == originColor ) dfs(image, sr, sc - 1, newColor, originColor, isVisted);
        if ( sc + 1 < image[0].length && isVisted[sr][sc + 1] == false && image[sr][sc + 1] == originColor ) dfs(image, sr, sc + 1, newColor, originColor, isVisted);
    }
}
