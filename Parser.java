package ru.sbt;


import java.util.HashMap;
import java.util.Scanner;

public class Parser {

    public Client metodIf(Scanner scanner) {
        HashMap<String, String> mapData = getData(scanner);
        Client client = new Client("", 0);
        if (mapData.get("clientType").equals("LEGAL_ENTITY"))
            return new LegalEntity(mapData.get("name"), Integer.parseInt(mapData.get("inn")), Integer.parseInt(mapData.get("income")));
        else if (mapData.get("clientType").equals("INDIVIDUAL"))
            return new Individual(mapData.get("name"), Integer.parseInt(mapData.get("inn")), mapData.get("lastname"));
        else if (mapData.get("clientType").equals("HOLDING"))
            return new Holding(mapData.get("name"), Integer.parseInt(mapData.get("inn")));
        return client;
    }

    public Client metodEnum(Scanner scanner) {
        HashMap<String, String> dataHash = getData(scanner);
        return Type.newClient(dataHash);
    }

    private static HashMap<String, String> getData(Scanner scanner) {
        HashMap<String, String> mapData = new HashMap<>();
        int num;
        while (scanner.hasNext()) {
            String key, val;
            scanner.useDelimiter("\"");
            scanner.next();
            key = scanner.next();
            scanner.skip("\": ");
            scanner.useDelimiter(",|\\r|\\n");
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
                mapData.put(key, "" + num);
                try {
                    scanner.skip(",");
                } catch (Exception e) {
                    break;
                }
            } else {
                scanner.useDelimiter("\"");
                val = scanner.next();
                mapData.put(key, val);
                try {
                    scanner.skip("\",");
                } catch (Exception e) {
                    break;
                }
            }
        }
        return mapData;
    }
}
