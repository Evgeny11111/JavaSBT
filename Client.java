package ru.sbt;

import java.util.Objects;

public class Client {
    private final String name;
    private final int inn;

    public Client(String name, int inn) {
        this.name = name;
        this.inn = inn;
    }

    public String getName() {
        return name;
    }

    public int getInn() {
        return inn;
    }

    @Override
    public String toString() {
        return  name + ' ' + inn;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Client another = (Client) obj;
        return inn == another.inn && name.equals(another.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, inn);
    }
}
