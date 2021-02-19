import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ReadWrite {
    public static List<Triangle> readFile(File file) throws IOException {
        return Files.readAllLines(Path.of(file.getPath())).stream()
                .map(Triangle::value)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public static void writeintoFile(File file, List<Triangle> triangleList) throws IOException {
        Triangle maxSpaceTriangle = triangleList.stream()
                .filter(Triangle::isIsoscelesTriangle)
                .max(Comparator.comparingDouble(Triangle::space))
                .get();

        String result = maxSpaceTriangle.toString() + " " + maxSpaceTriangle.space();
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(result);
        writer.close();
    }
}