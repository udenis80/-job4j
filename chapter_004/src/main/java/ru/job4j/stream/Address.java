package ru.job4j.stream;

import java.util.Comparator;
import java.util.Objects;

public class Address implements Comparator {
    private String city;
    private String street;
    private int home;
    private int apartment;

    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getHome() {
        return home;
    }

    public int getApartment() {
        return apartment;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", home=" + home +
                ", apartment=" + apartment +
                '}';
    }

    @Override
    public int compare(Object o1, Object o2) {
        Address left = (Address) o1;
        Address right = (Address) o2;
        return left.getCity().compareTo(right.getCity());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Address address = (Address) obj;
        return city.equals(address.getCity()) && street.equals(address.getStreet())
                && home == address.getHome() && apartment == address.getApartment();
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, home, apartment);
    }

}