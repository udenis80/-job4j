package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {

    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }
    @Test
    public void whenFirstMaxLessThird() {
        Max maxim1 = new Max();
        int result = maxim1.max(1, 2, 3);
        assertThat(result, is(3));
    }
}