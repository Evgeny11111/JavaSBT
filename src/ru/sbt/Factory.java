package ru.sbt;

import java.util.List;

public interface Factory<T> {
    JsonGenerator<T> createGenerator(T object);
}

interface JsonGenerator<T>{
    String toJson(List<T> entites);
}
