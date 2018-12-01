package ru.job4j.array;

import org.hamcrest.Matchers;
import org.junit.Test;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        BubbleSort sorter = new BubbleSort();
        int[] array = new int[]{5, 10, 3, 2, 4, 9, 8, 7, 6, 1};
        int[] result = sorter.sort(array);
        int[] expect = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertThat(result, Matchers.is(expect));
    }
}
