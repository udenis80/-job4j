package ru.job4j.stream;

public class Student {

    private String surName;
    private int score;

    public String getSurName() {
        return surName;
    }

    public int getScore() {
        return score;
    }

    public Student(String surName, int score) {
        this.surName = surName;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "surName='" + surName + '\'' +
                ", score=" + score +
                '}';
    }
}
