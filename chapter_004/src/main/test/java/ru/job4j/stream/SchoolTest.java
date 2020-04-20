package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SchoolTest {
    @Test
    public void classACollectTest() {
        School school = new School();
        List<Student> students = Arrays.asList(
                new Student("A", 77),
                new Student("B", 92),
                new Student("C", 25)
        );
        List<Student> classA = school.collect(students, x -> x.getScore() >= 70);
        assertThat(2, is(classA.size()));
    }
    @Test
    public void classBCollectTest() {
        School school = new School();
        List<Student> students = Arrays.asList(
                new Student("A", 55),
                new Student("B", 52),
                new Student("C", 67)
        );
        List<Student> classB = school.collect(students, x -> x.getScore() >= 50 && x.getScore() < 70);
        assertThat(3, is(classB.size()));
    }
    @Test
    public void classCCollectTest() {
        School school = new School();
        List<Student> students = Arrays.asList(
                new Student("A", 77),
                new Student("B", 92),
                new Student("C", 25)
        );
        List<Student> classC = school.collect(students, x -> x.getScore() < 50);
        assertThat(1, is(classC.size()));
    }
}