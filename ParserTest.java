import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ParserTest {

    @org.junit.Test
    public void metodIf() {
        {
            String s = "{\n" + "  \"name\": \"PepsiCo\",\n" + "  \"inn\": 95238414,\n" + "  \"clientType\": \"HOLDING\"\n" + "}";
            Scanner scanner = new Scanner(s);
            assertEquals(Parser.metodIf(scanner), new Holding("PepsiCo", 95238414));
        }
        {
            String s = "{\n" + "  \"name\": \"Anton\",\n" + "  \"inn\": 12345232,\n"+ "  \"lastname\": \"Belokopitov\",\n" + "  \"clientType\": \"INDIVIDUAL\"\n" + "}";
            Scanner scanner = new Scanner(s);
            assertEquals(Parser.metodIf(scanner), new Individual("Anton", 12345232,"Belokopitov"));
        }
        {
            String s = "{\n" + "  \"name\": \"OOO Спортмастер\",\n" + "  \"inn\": 34568414,\n"  + "  \"income\": 100000000,\n" + "  \"clientType\": \"LEGAL_ENTITY\"\n" + "}";
            Scanner scanner = new Scanner(s);
            assertEquals(Parser.metodIf(scanner), new LegalEntity("OOO Спортмастер", 34568414,100000000));
        }
    }

    @org.junit.Test
    public void metodEnum() {
        String s = "{\n" + "  \"name\": \"PepsiCo\",\n" + "  \"inn\": 95238414,\n" + "  \"clientType\": \"HOLDING\"\n" + "}";
        Scanner scanner = new Scanner(s);
        assertEquals( Parser.metodEnum(scanner),new Holding("PepsiCo", 95238414));
    }
    {
        String s = "{\n" + "  \"name\": \"Anton\",\n" + "  \"inn\": 12345232,\n"+ "  \"lastname\": \"Belokopitov\",\n" + "  \"clientType\": \"INDIVIDUAL\"\n" + "}";
        Scanner scanner = new Scanner(s);
        assertEquals(Parser.metodEnum(scanner), new Individual("Anton", 12345232,"Belokopitov"));
    }
    {
        String s = "{\n" + "  \"name\": \"OOO Спортмастер\",\n" + "  \"inn\": 34568414,\n" + "  \"income\": 100000000,\n" + "  \"clientType\": \"LEGAL_ENTITY\"\n" + "}";
        Scanner scanner = new Scanner(s);
        assertEquals(Parser.metodEnum(scanner), new LegalEntity("OOO Спортмастер", 34568414,100000000));
    }
}