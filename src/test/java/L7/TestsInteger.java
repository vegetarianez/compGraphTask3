package L7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TestsInteger {
    MyList<Integer> list = new MyList<>();



    @Test
    @DisplayName("add")
    void AddTest() {
        assertEquals(list.getSize(), 0);
        list.add(4);
        assertEquals(list.getSize(), 1);
        assertEquals(list.getTail().getValue(), 4);
        assertEquals(list.getHead().getValue(), 4);
        list.add(99);
        assertEquals(list.getSize(), 2);
        assertEquals(list.getTail().getValue(), 99);
        assertEquals(list.getHead().getValue(), 4);
    }
    @Test
    @DisplayName("delete without node")
    void delete1() {
        list.add(4);
        list.add(99);
        list.delete();
        assertEquals(list.getSize(), 1);
        assertEquals(list.getTail().getValue(), 4);
        assertEquals(list.getHead().getValue(), 4);
        list.delete();
        assertEquals(list.getSize(), 0);
    }
    @Test
    @DisplayName("delete with node")
    void delete2() {
        list.add(65);
        list.add(4);
        list.add(65);
        list.add(99);
        list.add(65);
        list.add(65);
        list.add(34);
        list.add(65);
        list.delete(65);
        assertEquals(list.getSize(), 3);
        assertEquals(list.getTail().getValue(), 34);
        assertEquals(list.getHead().getValue(), 4);
    }
    @Test
    @DisplayName("find")
    void findByValueTest() {
        list.add(77);
        list.add(72);
        assertEquals(list.findByValue(77).getValue(), 77);
        assertEquals(list.findByValue(72).getValue(), 72);
    }
    // :)
}
