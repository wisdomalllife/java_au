import java.util.List;

public class Searching {

    public static boolean isThereNumber(ComplexNumber complex, List<ComplexNumber> complexList) {
        return complexList.stream().anyMatch(p -> p.equals(complex));
    }

    public static long complexCount(ComplexNumber complex, List<ComplexNumber> complexList) {
        return complexList.stream().filter(p -> p.equals(complex)).count();
    }

}