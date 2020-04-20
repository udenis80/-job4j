package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    @Test
    public void profilesCollectTest() {
        List<Profile> profileses = Arrays.asList(
                new Profile(new Address("Moscow", "Lenina", 25, 100)),
                new Profile(new Address("Moscow", "Lenina", 25, 100)),
                new Profile(new Address("Sochi", "Lenina", 25, 23)));
        List result = Profiles.collect(profileses);
        assertThat(2, is(result.size()));
    }
}