import java.util.Objects;

public class Holding extends Client {

    public Holding(String name, int inn) {
        super(name, inn);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this != obj) return false;
        if ((obj == null) || !(obj instanceof Objects)) return false;
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }
}
