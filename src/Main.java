/**
 * Lesson_4
 **/

public class Main {
    public static void main(String[] args) {

        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Ivanov Ivan Ivanovich", "QA", "ivanovich@gmail.com", "+375291111111", 70000.0, 20);
        employees[1] = new Employee("Chekhov Anton Pavlovich", "AQA", "pavlovich@gmail.com", "+375292222222", 80000.0, 42);
        employees[2] = new Employee("Pushkin Alexander Sergeevich", "JAVA", "sidorov@gmail.com", "+375293333333", 190000.0, 35);
        employees[3] = new Employee("Tolstoy Lev Nicolaevich", "SA", "sergeevich@gmail.com", "+375294444444", 80000.0, 45);
        employees[4] = new Employee("Bulgakov Mikhail Afanasyevich ", "PM", "afanasyevich@gmail.com", "+375295555555", 70000.0, 18);

        Employee employees2 = new Employee("Ivanov Ivan Ivanovich", "QA", "ivanovich@gmail.com", "+375291111111", 70000.0, 20);
        System.out.println("Задание 1");
        employees2.printInfo();
        System.out.println();

        System.out.println("Задание 2");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].age > 40) {
                employees[i].printInfo();
            }
        }
    }
}