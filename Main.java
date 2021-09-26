
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws Exception {
        try {
            Client client;
            Path path = FileSystems.getDefault().getPath("C:\\Users\\Evgeny\\Desktop\\Java\\firstHometask\\src", "Example");
            Scanner scanner = new Scanner(path);
            client = Parser.metodIf(scanner);
            System.out.println(client.toString() + ' ' + client.getClass() );
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
