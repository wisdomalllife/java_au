import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) { // проверка что  мы получили текст и файл для текста
            return;
        }
        ReadWrite.writeintoFile(new File(args[1]), ReadWrite.readFile(new File(args[0])));
    }
}
