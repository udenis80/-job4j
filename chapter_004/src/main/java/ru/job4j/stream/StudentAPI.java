package ru.job4j.stream;

public class StudentAPI implements Comparable<StudentAPI> {

private String name;
private int scope;

    public StudentAPI(String name, int scope) {
        this.name = name;
        this.scope = scope;
    }

    public String getName() {
        return name;
    }

    public int getScope() {
        return scope;
    }

    @Override
    public int compareTo(StudentAPI studentAPI) {
        return Integer.compare(scope, studentAPI.scope);
    }

    @Override
    public String toString() {
        return "StudentAPI{" +
                "name='" + name + '\'' +
                ", scope=" + scope +
                '}';
    }
}