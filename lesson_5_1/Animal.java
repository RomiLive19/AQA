package lesson_5_1;

public abstract class Animal {
    private static int count = 0;
    public String name;

    public Animal(String name) {
        this.name = name;
        count++;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);


    public static int getCount() {
        return count;
    }
}