package ru.sbt;

public class Person {
    private final Long id;
    private final String name;
    private final String lastname;

    public Person(Long id, String name, String lastname) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }
}
