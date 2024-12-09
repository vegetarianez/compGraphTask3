package L6;


import L6.model.Engine;
import L6.model.Motorcycle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class Tests {

    final Engine engine1 = new Engine("B-340", 200, 1500);
    final Engine engine2 = new Engine("T-670", 450, 3000);
    final Engine engine3 = new Engine("RT-40", 124, 950);
    final Engine engine4 = new Engine("RT-40", 124, 950);

    final Motorcycle motorcycle1 = new Motorcycle("Hawasaki", 1996, engine1);
    final Motorcycle motorcycle2 = new Motorcycle("Opel", 1990, engine1);
    final Motorcycle motorcycle3 = new Motorcycle("Hiro", 2007, engine1);

    final Motorcycle motorcycle4 = new Motorcycle("Hawasaki", 1988, engine2);
    final Motorcycle motorcycle5 = new Motorcycle("Dodge", 1996, engine2);
    final Motorcycle motorcycle6 = new Motorcycle("Yamaha", 2015, engine2);

    final Motorcycle motorcycle7 = new Motorcycle("Honda", 1996, engine3);
    final Motorcycle motorcycle8 = new Motorcycle("BMW", 1996, engine3);

    final Motorcycle motorcycle9 = new Motorcycle("Hawasaki", 1996, engine1);

    @Test
    @DisplayName("L6.hash")
    void HashCodeMotorcycle() {
        assertEquals(motorcycle1.hashCode(), motorcycle9.hashCode());
        assertNotEquals(motorcycle1, motorcycle2);
    }

    @Test
    @DisplayName("L6.equals")
    void equalsEngine() {
        assertEquals(engine3, engine4);
        assertNotEquals(engine1, engine4);
    }

    @Test
    public void sortEngine() {
        List<Engine> engines = Arrays.asList(engine1, engine2, engine3);
        Collections.sort(engines);
        List<Engine> expected = Arrays.asList(engine1, engine3, engine2);
        assertEquals(engines, expected);
    }

    @Test
    public void sortMotorcycle() {
        List<Motorcycle> motorcycles = Arrays.asList(motorcycle1, motorcycle2, motorcycle4, motorcycle3);
        Collections.sort(motorcycles);
        List<Motorcycle> expected = Arrays.asList(motorcycle1, motorcycle2, motorcycle3, motorcycle4);
        assertEquals(motorcycles, expected);
    }

}