package lesson_5_1;

public class Food {
    private int food;

    public Food(int food) {
        this.food = Math.max(food, 0);
    }

    public void addFood(int amount) {
        if (amount > 0) {
            food = food + amount;
            System.out.println("Добавили " + amount + " еды." + " Стало " + food + " еды.");
        }
    }

    public void decreaseFood(int amount) {
        if (amount <= food) {
            food = food - amount;
        }
    }

    public int getFood() {
        return food;
    }
}

