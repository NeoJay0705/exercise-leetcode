package org.exercise.algo.twopointer;

// 167

public class TwoSumSecInputArrayIsSorted {
    public static void main(String[] args) {
        final class Input {
            int[] numbers;
            int target;
            public Input(int[] numbers, int target) {
                this.numbers = numbers;
                this.target = target;
            }
        }

        TwoSumSecInputArrayIsSorted two = new TwoSumSecInputArrayIsSorted();

        Input[] inputs = new Input[] {
                                        new Input(new int[]{1,5,5}, 10),
                                        new Input(new int[]{1,2,8}, 10),
                                        new Input(new int[]{2,2,8}, 10),
                                        new Input(new int[]{2,8,8}, 10),
                                     };
        for ( Input i : inputs ) {
            int[] result = two.twoSum(i.numbers, i.target);
            if ( result.length > 1 )
                System.out.println(result[0] + "  " + result[1]);
        }
    }

    public int[] twoSum(int[] numbers, int target) {
        int firstIndex = -1;
        int secondIndex = -1;
        for ( int i = 0; i < numbers.length - 1 && firstIndex == -1; ++i ) {
            int low = i + 1;
            int high = numbers.length - 1;
            while ( low <= high && firstIndex == -1 ) {
                int mid = (low + high) / 2;
                if ( target < numbers[i] + numbers[mid] ) high = mid - 1;
                else if ( target > numbers[i] + numbers[mid] ) low = mid + 1;
                else {
                    firstIndex = i;
                    secondIndex = mid;
                }
            }
        }

        return firstIndex > -1 ? new int[]{ firstIndex + 1, secondIndex + 1 } : new int[]{};
    }

    public int[] twoSumII(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while ( left < right ) {
            int sum = numbers[left] + numbers[right];
            if ( sum > target ) right--;
            else if ( sum < target ) left++;
            else return new int[] { left + 1, right + 1 };
        }

        return new int[] { left + 1, right + 1 };
    }
}
