package L6.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.Objects;


@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Engine implements Comparable<Engine> {

    private String type;
    private int horsepower;
    private double capacity;

    public Engine(String type, int horsepower, double capacity) {
        this.type = type;
        this.horsepower = horsepower;
        this.capacity = capacity;
    }

    @Override
    public int compareTo(Engine o) {

       return this.type.compareTo(o.type);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Engine)) {
            return false;
        }
        Engine engine = (Engine) obj;
        return horsepower == engine.horsepower && Double.compare(engine.capacity, capacity) == 0 && Objects.equals(type, engine.type);
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = (int) (31 * result + horsepower + capacity);
        return result;
    }

}
