package ru.sbt;


import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ParserTest {

    @org.junit.Test
    public void metodIf1() throws IOException {
        Parser parser = new Parser();
        Path path = FileSystems.getDefault().getPath("C:\\Users\\Evgeny\\Desktop\\Java\\firstHometask\\src", "ru/sbt/tests/ExampleTest1");
        Scanner scanner = new Scanner(path);
        assertEquals(parser.metodIf(scanner), new Holding("PepsiCo", 95238414));
    }

    @org.junit.Test
    public void metodIf2() throws IOException {
        Parser parser = new Parser();
        Path path = FileSystems.getDefault().getPath("C:\\Users\\Evgeny\\Desktop\\Java\\firstHometask\\src", "ru/sbt/tests/ExampleTest2");
        Scanner scanner = new Scanner(path);
        assertEquals(parser.metodIf(scanner), new Individual("Anton", 12345232, "Belokopitov"));

    }

    @org.junit.Test
    public void metodIf3() throws IOException {
        Parser parser = new Parser();
        Path path = FileSystems.getDefault().getPath("C:\\Users\\Evgeny\\Desktop\\Java\\firstHometask\\src", "ru/sbt/tests/ExampleTest3");
        Scanner scanner = new Scanner(path);
        assertEquals(parser.metodIf(scanner), new LegalEntity("OOO Спортмастер", 34568414, 100000000));
    }

    @org.junit.Test
    public void metodEnum1() throws IOException {
        Parser parser = new Parser();
        Path path = FileSystems.getDefault().getPath("C:\\Users\\Evgeny\\Desktop\\Java\\firstHometask\\src", "ru/sbt/tests/ExampleTest1");
        Scanner scanner = new Scanner(path);
        assertEquals(parser.metodEnum(scanner), new Holding("PepsiCo", 95238414));

    }

    @org.junit.Test
    public void metodEnum2() throws IOException {
        Parser parser = new Parser();
        Path path = FileSystems.getDefault().getPath("C:\\Users\\Evgeny\\Desktop\\Java\\firstHometask\\src", "ru/sbt/tests/ExampleTest2");
        Scanner scanner = new Scanner(path);
        assertEquals(parser.metodEnum(scanner), new Individual("Anton", 12345232, "Belokopitov"));
    }

    @org.junit.Test
    public void metodEnum3() throws IOException {
        Parser parser = new Parser();
        Path path = FileSystems.getDefault().getPath("C:\\Users\\Evgeny\\Desktop\\Java\\firstHometask\\src", "ru/sbt/tests/ExampleTest3");
        Scanner scanner = new Scanner(path);
        assertEquals(parser.metodEnum(scanner), new LegalEntity("OOO Спортмастер", 34568414, 100000000));
    }
}