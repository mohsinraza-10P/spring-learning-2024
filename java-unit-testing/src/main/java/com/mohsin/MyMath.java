package com.mohsin;

public class MyMath {

    // 1 + 2 + 3 = 6
    public int
    calculateSum(int[] numbers) {
        int sum = 0;
        for (int i : numbers) {
            sum += i;
        }
        return sum;
        // return Arrays.stream(numbers).sum();
    }
}
