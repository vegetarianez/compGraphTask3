package CGTask3.normals;

import CGTask3.math.Vector3f;
import CGTask3.model.Model;
import CGTask3.model.Polygon;

import java.util.*;

public class CalculateNormals {
    //Bx-Ax, By-Ay, Bz-Az
    public static Vector3f calculateVectorByDots(Vector3f a, Vector3f b) {
        return new Vector3f(b.getX()-a.getX(), b.getY()-a.getY(), b.getZ()-a.getZ());
    }
    public static Vector3f vectorMultiply(Vector3f a, Vector3f b) {
        return new Vector3f(a.getY() * b.getZ() - b.getY() * a.getZ(), -a.getX() * b.getZ() + b.getX() * a.getZ(), a.getX() * b.getY() - b.getX() * a.getY());
    }
    public static double determinant(Vector3f a, Vector3f b, Vector3f c) {
        return a.getX() * (b.getY() * c.getZ()) - a.getY() * (b.getX() * c.getZ() - c.getX() * b.getZ()) + a.getZ() * (b.getX() * c.getY() - c.getX() * b.getY());
    }


    public static Vector3f calculateNormalOfPolygon(Vector3f[] dots) {
        Vector3f a = calculateVectorByDots(dots[0], dots[1]);
        Vector3f b = calculateVectorByDots(dots[0], dots[2]);
        Vector3f c = vectorMultiply(a, b);
        if (determinant(a, b, c) < 0) {
            c = vectorMultiply(b, a);
        }
        return c;
    }

    public static ArrayList<Vector3f> calculateNormals(Model model) {
        ArrayList<Polygon> polygons = model.polygons;
        ArrayList<Vector3f> vertices = model.vertices;
        ArrayList<Vector3f> polygonNormals = new ArrayList<>();
        ArrayList<Vector3f> normals = new ArrayList<>();

        for (Polygon p : polygons) {
            ArrayList<Integer> vertexIndices = p.getVertexIndices();
            Vector3f dot1 = vertices.get(vertexIndices.get(0));
            Vector3f dot2 = vertices.get(vertexIndices.get(1));
            Vector3f dot3 = vertices.get(vertexIndices.get(2));
            Vector3f[] dots = new Vector3f[3];
            dots[0] = dot1;
            dots[1] = dot2;
            dots[2] = dot3;
            polygonNormals.add(calculateNormalOfPolygon(dots));
        }

        Map<Integer, LinkedList<Vector3f>> vertexPolygonsMap = new HashMap<>();
        for (int i = 0; i < polygons.size(); i++) {
            List<Integer> vertexIndices = polygons.get(i).getVertexIndices();
            Vector3f vector = polygonNormals.get(i);
            for (Integer index : vertexIndices) {
                vertexPolygonsMap.computeIfAbsent(index, key -> new LinkedList<>()).add(vector);
            }
        }

        for (int i = 0; i < vertices.size(); i++) {
            normals.add(calculateNormalOfVertex(vertexPolygonsMap.get(i)));
        }

        return normals;
    }
    public static Vector3f calculateNormalOfVertex(LinkedList<Vector3f> listOfVectors) {
        float sumOfX = 0;
        float sumOfY = 0;
        float sumOfZ = 0;
        for (Vector3f v : listOfVectors) {
            sumOfX += v.getX();
            sumOfY += v.getY();
            sumOfZ += v.getZ();
        }
        sumOfX /= listOfVectors.size();
        sumOfY /= listOfVectors.size();
        sumOfZ /= listOfVectors.size();
        Vector3f vectorNormal = new Vector3f(sumOfX, sumOfY, sumOfZ);
        return normalize(vectorNormal);
    }
    public static Vector3f normalize(Vector3f vector) {
        if (vector.getX() == 0) {
            return new Vector3f(0, 0, 0);
        }
        float coefficient = 1/vector.getX();
        float newX = vector.getX() * coefficient;
        float newY = vector.getY() * coefficient;
        float newZ = vector.getZ() * coefficient;

        return new Vector3f(newX, newY, newZ);
    }
}
