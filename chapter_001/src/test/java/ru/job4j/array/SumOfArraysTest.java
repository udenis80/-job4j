package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SumOfArraysTest {
    @Test
    public void sortedArray() {
        int[] input1 = {1, 2, 3};
        int[] input2 = {2, 3, 4};
        int[] expect = {1, 2, 2, 3, 3, 4};
        SumOfArrays results = new SumOfArrays();
        int[] result = results.best(input1, input2);
        assertThat(result, is(expect));
    }
}