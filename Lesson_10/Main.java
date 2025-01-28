/**
 * Lesson_10
 **/

public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox1 = new Box<>();
        Box<Apple> appleBox2 = new Box<>();
        Box<Orange> orangeBox = new Box<>();

        appleBox1.addFruit(new Apple());
        appleBox1.addFruit(new Apple());
        appleBox1.addFruit(new Apple());

        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());

        System.out.println("Вес коробки с яблоками 1: " + appleBox1.getWeight());
        System.out.println("Вес коробки с апельсинами: " + orangeBox.getWeight());

        System.out.println("Коробки одинаково весят? " + appleBox1.compare(orangeBox));

        appleBox1.transferFruitsTo(appleBox2);
        System.out.println("Коробка с яблоками 1 после пересыпания: " + appleBox1);
        System.out.println("Коробка с яблоками 2 после пересыпания: " + appleBox2);

        try {
            throw new IllegalArgumentException("Нельзя пересыпать фрукты разных типов!");
        } catch (Exception e) {
            System.out.println("Ошибка: Нельзя пересыпать фрукты разных типов.");
        }
    }
}
