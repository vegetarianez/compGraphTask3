package CGTask3;



import CGTask3.math.Vector3f;
import CGTask3.normals.CalculateNormals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;


class Tests {
    Vector3f v1 = new Vector3f(1, -2, 1);
    Vector3f v2 = new Vector3f(2, 1, -2);
    Vector3f v3 = new Vector3f(-1, -1, 3);

    Vector3f[] polygon1 = new Vector3f[]{new Vector3f(0, 0, 0), new Vector3f(1, 0, 0), new Vector3f(0, 1, 0)};
    Vector3f v4 = new Vector3f(0, 0, 0);
    Vector3f v5 = new Vector3f(1, 0, 0);
    Vector3f v6 = new Vector3f(0, 1, 0);
    Vector3f ans3 = new Vector3f(0, 0, 1);

    Vector3f dot1 = new Vector3f(2, -1, 4);
    Vector3f dot2 = new Vector3f(5, 1, -3);
    Vector3f ans1 = new Vector3f(3, 2, -7);
    Vector3f ans2 = new Vector3f(3, 4, 5);

    Vector3f v7 = new Vector3f(3, 6, 9);
    Vector3f v8 = new Vector3f(1, 2, 3);

    @Test
    @DisplayName("determinant")
    void Determinant() {
        assertEquals(CalculateNormals.determinant(v1, v2, v3), 8);
    }

    @Test
    @DisplayName("vector by two dots")
    void vectorByTwoDots() {
        Vector3f a = CalculateNormals.calculateVectorByDots(dot1, dot2);
        assertEquals(a.getX(), ans1.getX());
        assertEquals(a.getY(), ans1.getY());
        assertEquals(a.getZ(), ans1.getZ());

    }

    @Test
    @DisplayName("vector multiply")
    public void vectorMultiply() {
        Vector3f a = CalculateNormals.vectorMultiply(v1, v2);
        assertEquals(a.getX(), ans2.getX());
        assertEquals(a.getY(), ans2.getY());
        assertEquals(a.getZ(), ans2.getZ());
    }

    @Test
    @DisplayName("normal of polygon")
    public void normalOfPolygon() {
        Vector3f a = CalculateNormals.calculateNormalOfPolygon(polygon1);
        assertEquals(a.getX(), ans3.getX());
        assertEquals(a.getY(), ans3.getY());
        assertEquals(a.getZ(), ans3.getZ());
    }

    @Test
    @DisplayName("normalization")
    public void Normalization() {
        assertEquals(CalculateNormals.normalize(v7).getY(), v8.getY());
        assertEquals(CalculateNormals.normalize(v7).getX(), v8.getX());

        assertEquals(CalculateNormals.normalize(v7).getZ(), v8.getZ());
    }

}