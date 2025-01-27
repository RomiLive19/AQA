/**
 * Lesson_9
 **/

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> randomNumbers = Utils.generateRandomNumbers(5, 30, 100);
        System.out.println("1. Список случайных чисел: " + randomNumbers);
        System.out.println("Количество четных чисел: " + Utils.countEvenNumbers(randomNumbers));

        List<String> collection = Arrays.asList("Highload", "High", "Load", "Highload");
        System.out.println("2. Коллекция строк: " + collection);
        System.out.println("Количество 'High': " + Utils.countOccurrences(collection, "High"));
        System.out.println("Первый элемент: " + Utils.getFirstElement(collection));
        System.out.println("Последний элемент: " + Utils.getLastElement(collection));

        List<String> strings = Arrays.asList("f10", "f15", "f2", "f4", "f4");
        List<String> sortedStrings = Utils.sortStrings(strings);
        System.out.println("3. Отсортированные строки: " + sortedStrings);

        Collection<Student> students = Arrays.asList(
                new Student("Дмитрий", 17, Gender.MAN),
                new Student("Максим", 20, Gender.MAN),
                new Student("Екатерина", 20, Gender.WOMAN),
                new Student("Михаил", 28, Gender.MAN)
        );

        System.out.println("4. Список студентов:");
        for (Student student : students) {
            System.out.println(student);
        }

        double averageAge = students.stream()
                .filter(student -> student.getGender() == Gender.MAN)
                .mapToInt(Student::getAge)
                .average()
                .orElse(0);
        System.out.println("4.1. Средний возраст студентов мужского пола: " + averageAge);

        List<Student> draftStudents = students.stream()
                .filter(student -> student.getGender() == Gender.MAN)
                .filter(student -> student.getAge() >= 18 && student.getAge() <= 27)
                .collect(Collectors.toList());
        System.out.println("4.2. Студенты, которым грозит повестка:");
        draftStudents.forEach(System.out::println);

        Scanner scanner = new Scanner(System.in);
        List<String> logins = new ArrayList<>();
        System.out.println("5. Ввести логин: (для завершения введите пустую строку):");

        while (true) {
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                break;
            }
            logins.add(input);
        }

        List<String> filteredLogins = logins.stream()
                .filter(login -> login.toLowerCase().startsWith("f"))
                .collect(Collectors.toList());

        System.out.println("Логины, начинающиеся на 'f':");
        filteredLogins.forEach(System.out::println);
    }
}