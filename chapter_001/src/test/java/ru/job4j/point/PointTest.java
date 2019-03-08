package ru.job4j.point;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void test() {
        Point first = new Point(3, 4); //создаете первую точку
        Point second = new Point(0, 0); //создаете вторую точку
        double distance = first.distanceTo(second); // рассчитываете расстояние между ними
        assertThat(distance, is(5d)); // сравниваете результат с ожидаемым
    }
}