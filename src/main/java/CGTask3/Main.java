package CGTask3;

import CGTask3.math.Vector3f;
import CGTask3.model.Model;
import CGTask3.normals.CalculateNormals;
import CGTask3.objreader.ObjReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        Path fileName = Path.of("C:\\Users\\Nick\\IdeaProjects\\OOP_6_group_template-main\\src\\main\\java\\CGTask3\\objfolder\\caracal_cube.obj");
        String fileContent = Files.readString(fileName);

        System.out.println("Loading model ...");
        Model model = ObjReader.read(fileContent);
        for (Vector3f i : model.vertices) {
            System.out.println("Vertice: " + i.getX() + ", " + i.getY() + ", " + i.getZ());
        }
        System.out.println("----------------");
        for (Vector3f i : model.normals) {
            System.out.println("Normal: " + i.getX() + ", " + i.getY() + ", " + i.getZ());
        }
        System.out.println("----------------");
        model.setNormals(CalculateNormals.calculateNormals(model));
        for (Vector3f i : model.normals) {
            System.out.println("Normal: " + i.getX() + ", " + i.getY() + ", " + i.getZ());
        }

        System.out.println("Vertices: " + model.vertices.size());
        System.out.println("Texture vertices: " + model.textureVertices.size());
        System.out.println("Normals: " + model.normals.size());
        System.out.println("Polygons: " + model.polygons.size());




    }
}
