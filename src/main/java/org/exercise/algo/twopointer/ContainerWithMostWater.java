package org.exercise.algo.twopointer;

// 11

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int size;
        int tmpHeight;
        int max = 0;
        while ( i < j ) {
            if ( height[j] < height[i] ) {
                size = height[j] * (j - i);
                tmpHeight = height[j];
                j--;
                while ( i < j && height[j] < tmpHeight ) j--;
            }
            else {
                size = height[i] * (j - i);
                tmpHeight = height[i];
                i++;
                while ( i < j && height[i] < tmpHeight ) i++;
            }
            if ( size > max ) max = size;
        }

        return max;
    }
}
