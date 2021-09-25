import java.util.HashMap;
import java.util.Map;

public class ClientType {
    private static final Map<String, ClientType.type> m = new HashMap<>();
    enum type {
        HOLDING {
            @Override
            Client createClient(Map<String, String> data) {
                return new Holding(data.get("name"), Integer.parseInt(data.get("inn")));
            }
        },
        INDIVIDUAL {
            @Override
            Client createClient(Map<String, String> data) {
                return new Individual(data.get("name"), Integer.parseInt(data.get("inn")), data.get("lastname"));
            }
        },
        LEGAL_ENTITY {
            @Override
            Client createClient(Map<String, String> data) {
                return new LegalEntity(data.get("name"), Integer.parseInt(data.get("inn")), Integer.parseInt(data.get("income")));
            }
        };
        static {
            m.put("HOLDING", HOLDING);
            m.put("LEGAL_ENTITY", LEGAL_ENTITY);
            m.put("INDIVIDUAL", INDIVIDUAL);
        }
        static Client newClient(Map<String,String> data){
            return m.get(data.get("clientType").trim()).createClient(data);
        }
        abstract Client createClient(Map<String, String> data);
    }
}
