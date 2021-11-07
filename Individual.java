package ru.sbt;

import java.util.Objects;

public class Individual extends Client {
    private final String lastname;

    public Individual(String name, int inn,String lastname) {
        super(name, inn);
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return super.toString() + ' '+ lastname;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if ((obj == null) || getClass() != obj.getClass()) return false;
        Individual another = (Individual) obj;
        return super.equals(obj) && lastname.equals(another.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),lastname);
    }

    public String getLastname() {
        return lastname;
    }
}
