package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
  private static   Comparator<Address> byAddress = (o1, o2) -> o1.getCity().compareTo(o2.getCity());
    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress).sorted(byAddress).distinct()
                .collect(Collectors.toList());
    }
}