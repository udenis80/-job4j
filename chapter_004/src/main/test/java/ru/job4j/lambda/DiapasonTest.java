package ru.job4j.lambda;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.log;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DiapasonTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = Diapason.diapasonFunc(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadFunctionThenResults() {
        List<Double> result = Diapason.diapasonFunc(5, 8, x -> x * x);
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogFunctionThenResults() {
        List<Double> result = Diapason.diapasonFunc(5, 8, x -> log(x));
        List<Double> expected = Arrays.asList(1.6094379124341003D, 1.791759469228055D, 1.9459101490553132D);
        assertThat(result, is(expected));
    }
}