package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {

    public static List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(predict).collect(Collectors.toList());
    }

    public static Map<String, Student> listToMap(List<Student> students) {
        return students.stream().distinct().collect(Collectors.toMap(Student::getSurName, student -> student));
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("ivanov", 55),
                new Student("petrov", 56),
                new Student("putin", 79),
                new Student("lenin", 90),
                new Student("stalin", 56),
                new Student("pupkin", 40),
                new Student("sidorov", 30),
                new Student("smith", 50),
                new Student("popov", 51)
        );
        System.out.println(listToMap(students));
    }
}