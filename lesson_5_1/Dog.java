package lesson_5_1;

public class Dog extends Animal {
    public static int count = 0;

    public Dog(String name) {
        super(name);
        count++;
    }

    public void run(int distance) {
        if (distance <= 500) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать больше 500 м.");
        }
    }

    public void swim(int distance) {
        if (distance <= 10) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " не может проплыть больше 10 м.");
        }
        System.out.println();
    }

    public static int getCount() {
        return count;
    }
}