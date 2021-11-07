package ru.sbt;


import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws Exception {
        try {
            Client client;
            Parser parser = new Parser();
            Path path = FileSystems.getDefault().getPath("C:\\Users\\Evgeny\\Desktop\\Java\\firstHometask\\src", "ru/sbt/Example");
            Scanner scanner = new Scanner(path);
            client = parser.metodIf(scanner);
            System.out.println(client.toString() + ' ' + client.getClass() );
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
