import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) { // проверка что  мы получили текст и число
            return;
        }
        if (isThereNumber(number)) {
            complexCount(number, complexList);
        }
    }
}
