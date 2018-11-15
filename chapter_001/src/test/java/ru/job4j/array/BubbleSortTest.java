package ru.job4j.array;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        BubbleSort sorter= new BubbleSort();
        int[] array = new int[]{2, 1, 3, 4, 5};
        int[] result = sorter.sort(array);
        int[] expect = new int[]{1, 2, 3, 4, 5};
        assertThat(result, Matchers.is(expect));
    }
    //напишите здесь тест, проверяющий сортировку массива из 10 элементов методом пузырька, например {1, 5, 4, 2, 3, 1, 7, 8, 0, 5}.
}
