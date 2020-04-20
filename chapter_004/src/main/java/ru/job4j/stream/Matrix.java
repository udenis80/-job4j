package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Matrix {
    public static List<Integer> matrixToList(Integer[][] matrix) {
        return Arrays.stream(matrix).flatMap(Arrays::stream).collect(Collectors.toList());
    }
    public static void main(String[] args) {
        Integer[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9, 10}
        };
        System.out.println(Matrix.matrixToList(matrix));
    }
}