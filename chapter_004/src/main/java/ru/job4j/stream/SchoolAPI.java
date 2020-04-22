package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SchoolAPI {

   public static List<StudentAPI> levelOf(List<StudentAPI> students, int bound) {
       return students.stream().
               flatMap(Stream::ofNullable).
               sorted().
               takeWhile(studentAPI -> studentAPI.getScope() > bound).
               collect(Collectors.toList());
   }
}