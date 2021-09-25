
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args)throws Exception {
        try {
            Client client;
            Path path = FileSystems.getDefault().getPath("C:\\Users\\Evgeny\\Desktop\\Java\\firstHometask\\src", "test");
            client = Parser.parse(path);
            System.out.println(client.toString() + '}');
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
