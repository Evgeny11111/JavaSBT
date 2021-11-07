import java.util.HashMap;
import java.util.Map;

public class ClientType {
    private static final Map<String, ClientType.type> m = new HashMap<>();
    enum type {
        HOLDING {
             public Client createClient(Map<String, String> data) {
                return new Holding(data.get("name"), Integer.parseInt(data.get("inn")));
            }
        },
        INDIVIDUAL {
             public Client createClient(Map<String, String> data) {
                return new Individual(data.get("name"), Integer.parseInt(data.get("inn")), data.get("lastname"));
            }
        },
        LEGAL_ENTITY {
             public Client createClient(Map<String, String> data) {
                return new LegalEntity(data.get("name"), Integer.parseInt(data.get("inn")), Integer.parseInt(data.get("income")));
            }
        };
        public abstract Client createClient(Map<String, String> data);
        static {
            m.put("HOLDING", HOLDING);
            m.put("LEGAL_ENTITY", LEGAL_ENTITY);
            m.put("INDIVIDUAL", INDIVIDUAL);
        }
        static Client newClient(Map<String,String> data){
            type t = m.get(data.get("clientType").trim());
            return t.createClient(data);
        }

    }
}
