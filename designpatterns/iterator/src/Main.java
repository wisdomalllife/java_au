import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Student> listStudents = new MyLinkedList<>();
        listStudents.addAtHead(new Student("Ivanov", 202, 1));
        listStudents.addAtHead(new Student("Petrov", 202, 2));
        listStudents.addAtHead(new Student("Kozlov", 5, 3));

        for(Student student: listStudents) {
            System.out.println(student);
        }

        System.out.println("\n\n");
        Iterator<Student> studentIterator = listStudents.iterator();
        while (studentIterator.hasNext()) {
            System.out.println(studentIterator.next());
        }

    }
}
