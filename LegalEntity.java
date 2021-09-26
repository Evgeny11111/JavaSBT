import java.util.Objects;

public class LegalEntity extends Client {
    private final int income;

    public LegalEntity(String name, int inn, int income) {
        super(name, inn);
        this.income = income;
    }

    @Override
    public String toString() {
        return super.toString() + ' ' + income;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        LegalEntity another = (LegalEntity) obj;
        return super.equals(obj) && income == another.income;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), income);
    }

    public int getIncome() {
        return income;
    }
}
