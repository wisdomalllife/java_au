import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Read {
    public static List<ComplexNumber> readFile(File file) throws IOException {
        return file.stream()
                .map(Searching ::value)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
