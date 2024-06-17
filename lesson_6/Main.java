/**
 * Lesson_6
 **/

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        AppData data = new AppData();
        data.setHeader(new String[]{"Value 1", "Value 2", "Value 3"});
        data.setData(new int[][]{
                {100, 200, 123},
                {300, 400, 500}
        });
        CSVWriter.save(data, "data.csv");
        AppData loadedData = CSVReader.load("data.csv");

        printArray(loadedData.getHeader());
        for (int[] row : loadedData.getData()) {
            printArray(row);
        }
    }

    public static void printArray(String[] array) {
        System.out.println(String.join("; ", array));
    }

    public static void printArray(int[] array) {
        String[] stringArray = Arrays.stream(array)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);
        System.out.println(String.join("; ", stringArray));
    }
}
