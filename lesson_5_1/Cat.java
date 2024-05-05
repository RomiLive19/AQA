package lesson_5_1;

public class Cat extends Animal {
    private static int count = 0;
    private boolean isFull = false;

    public Cat(String name) {
        super(name);
        count++;
    }
    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать больше 200 м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public void eatFood(Food food) {
        if (food.getFood() >= 15) {
            food.decreaseFood(15);
            isFull = true;
            System.out.println(name + " сыт.");
        } else {
            System.out.println(name + " голодный.");
        }
    }
    public boolean isFull() {
        return isFull;
    }
    public static int getCount() {
        return count;
    }
}
