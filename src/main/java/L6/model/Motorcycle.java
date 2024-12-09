package L6.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Objects;


@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Motorcycle implements Comparable<Motorcycle>{
    private String model;
    private int year;
    private Engine engine;

    public Motorcycle(String model, int year, Engine engine) {
        this.model = model;
        this.year = year;
        this.engine = engine;
    }

    @Override
    public int compareTo(Motorcycle cycle) {
        return this.engine.compareTo(cycle.engine);
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public Engine getEngine() {
        return engine;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Motorcycle)) {
            return false;
        }
        Motorcycle motorcycle = (Motorcycle) obj;
        return year == motorcycle.year && Objects.equals(model, motorcycle.model) && Objects.equals(engine, motorcycle.engine);
    }

    public int hashCode() {
        int result = model.hashCode();
        result = 31 * result * year + engine.hashCode();
        return result;
    }

}
