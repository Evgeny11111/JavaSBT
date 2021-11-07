package ru.sbt;

import java.util.Map;


enum Type {
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

    static Client newClient(Map<String, String> data) {
        Type t = Type.valueOf(data.get("clientType").trim());
        return t.createClient(data);
    }

}
