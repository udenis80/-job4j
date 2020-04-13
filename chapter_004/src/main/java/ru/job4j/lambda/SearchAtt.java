package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchAtt {
    public static List<Attachment> filterSize(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getSize() > 100) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getName().contains("bug")) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("imagination", 90),
                new Attachment("passion", 134),
                new Attachment("velocity", 113)
        );
        attachments.stream().filter(p -> p.getSize() > 100).forEach(System.out::println);
        attachments.stream().filter(p -> p.getName().contains("on")).forEach(System.out::println);

    }
}