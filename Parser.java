import java.io.*;
import java.math.BigInteger;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Parser {

    public static Client parse(Path path) throws Exception {
        Scanner scanner = new Scanner(path);
        return metodEnum(scanner);
    }

    public static Client metodIf(Scanner scanner) {
        HashMap<String, String> m = getData(scanner);
        Client client = new Client("", 0);
        if (m.get("clientType").equals("LEGAL_ENTITY")) {
            return new LegalEntity(m.get("name"), Integer.parseInt(m.get("inn")), Integer.parseInt(m.get("income")));
        } else if (m.get("clientType").equals("INDIVIDUAL"))
            return new Individual(m.get("name"), Integer.parseInt(m.get("inn")), m.get("lastname"));
        else if (m.get("clientType").equals("HOLDING"))
            return new Holding(m.get("name"), Integer.parseInt(m.get("inn")));
        return client;
    }

    public static Client metodEnum(Scanner scanner) {
        HashMap<String, String> dataHash = getData(scanner);
        return ClientType.type.newClient(dataHash);
    }

    private static HashMap<String, String> getData(Scanner scanner) {
        HashMap<String, String> m = new HashMap<>();
        String line = scanner.nextLine();
        BigInteger num;
        if (line.charAt(0) != '{')
            throw new RuntimeException();
        while (scanner.hasNext()) {
            String key, val;
            scanner.useDelimiter("\"");
            scanner.next();
            key = scanner.next();
            scanner.skip("\": ");
            scanner.useDelimiter(",|\\r|\\n");
            if (scanner.hasNextBigInteger()) {
                num = scanner.nextBigInteger();
                m.put(key, "" + num);
                try {
                    scanner.skip(",");
                } catch (Exception e) {
                    break;
                }
            } else {
                scanner.useDelimiter("\"");
                val = scanner.next();
                m.put(key, val);
                try {
                    scanner.skip("\",");
                } catch (Exception e) {
                    break;
                }
            }
        }
        return m;
    }
}
