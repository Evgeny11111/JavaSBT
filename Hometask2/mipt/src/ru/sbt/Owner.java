package ru.sbt;

public class Owner {
    private final int ownerId;
    private final String name;
    private final String lastName;
    private final int age;

    public Owner(int ownerId, String name, String lastName, int age) {
        this.ownerId = ownerId;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public int getAge() {
        return age;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }
}
