package lesson_5_1;
/**
 * Lesson_5
 **/

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Гав");
        Cat cat = new Cat("Мяу");

        dog.run(550);
        dog.swim(5);

        cat.run(150);
        cat.swim(50);

        Food food = new Food(16);

        cat.eatFood(food);
        System.out.println("Сытость: " + cat.isFull());

        System.out.println();


        System.out.println("Всего животных: " + Animal.getCount());
        System.out.println("Всего собак: " + Dog.getCount());
        System.out.println("Всего котов: " + Cat.getCount());

        food.addFood(50);
    }
}