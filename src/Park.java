/**
 * Lesson_4
 **/

public class Park {

    public static class Attractions {

        public String information;
        public String worktime;
        public double cost;

        public Attractions(String information, String worktime, double cost) {
            this.information = information;
            this.worktime = worktime;
            this.cost = cost;
        }
    }


    public static void main(String[] args) {
        Attractions attr1 = new Attractions("Ладья", "09:00 - 22:00", 5.00);
        Attractions attr2 = new Attractions("Колесо обозрения", "09:00 - 20:00", 10.00);

        System.out.println("Информация об аттракционе 1: " + attr1.information + ", Время работы: " + attr1.worktime + ", Стоимость руб: " + attr1.cost);
        System.out.println("Информация об аттракционе 2: " + attr2.information + ", Время работы: " + attr2.worktime + ", Стоимость руб: " + attr2.cost);
    }
}