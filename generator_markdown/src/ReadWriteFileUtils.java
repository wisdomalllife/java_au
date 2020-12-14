import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadWriteFileUtils {
    // проверка на существование опущена
    // IOEx. - проверка на чтение стандартная
    public static TaskSolution readInTSolution(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));// считывает файл
        TaskSolution ans = new TaskSolution(); // создали класс по шаблону TaskSolution
        int symbol; // переменная для считывания char
        StringBuilder Solution = new StringBuilder(); // массив для чисел, который мы переведем в строку
        for (int i = 0; i < 3; i++) { // три раза читаем
            if(i == 0) {
                symbol = reader.read(); // считали один char
                while (symbol != 10) { // (int) '\n' = 10 - дошли до конца строчки
                    Solution.append((char)symbol); // вставляем в массив наши символы
                    symbol = reader.read();
                } // считали заголовок
                ans.setTitle(Solution.toString()); // переводим все int в char и объединяем в одну строку
                Solution.setLength(0); // обнуляем
            }else if(i == 1) {
                symbol = reader.read();
                while (symbol != 10) {
                    Solution.append((char)symbol);
                    symbol = reader.read();
                } // считали ссылку
                ans.setLink(Solution.toString());
                Solution.setLength(0);

            }else {
                symbol = reader.read();
                while (symbol != -1) { // (int) endOfFile = -1 - нашли конец файла
                    Solution.append((char)symbol);
                    symbol = reader.read();
                }
                ans.setSourceCode(Solution.toString());
            }// считали код
        }
        reader.close();
        return ans;

    }

    public static int getEndOfTitleLinks(File file) throws IOException{
        List<String> lines = Files.readAllLines(Path.of(file.getPath()));// каждый элемент массива - строка
        int output = 1; // для определения места вставки
        for (;output < lines.size(); output++) {
            if (!lines.get(output).startsWith("+[ ")) break;
        }
        return output;
    }
    public static void writeInMarkdown(TaskSolution cls, File markdown) throws IOException{
        List<String> lines = Files.readAllLines(Path.of(markdown.getPath()));
        lines.add(getEndOfTitleLinks(markdown) + 1, "+ [" + cls.getTitle().substring(0, cls.getTitle().length() - 1) + "](#" + cls.getLink().substring(30, cls.getLink().length() - 2) + ")");//substring для обрезания
        lines.add("## " + cls.getTitle());// cls - наш класс
        lines.add(cls.getLink());
        lines.add("```java");
        lines.add(cls.getSourceCode());
        lines.add("```");
        BufferedWriter writer = new BufferedWriter(new FileWriter(markdown));
        for (String s: lines) {
            writer.write(s + '\n');
        }
        writer.close();

    }
    public static void functionForLeetcode(String txtPath, String markdownPath) throws IOException {
        File textSolution = new File(txtPath); // txtPath - путь до файла. textSol. - ссылка на файл.
        if(!textSolution.exists()) return; // если не существует
        TaskSolution ClassSolution = readInTSolution(textSolution); // всё считали
        File md = new File(markdownPath); // создали файл для markdown
        writeInMarkdown(ClassSolution, md); // записали
    }
}
