/**
 * Lesson7
 **/

import lesson7.MyArrayDataException;
import lesson7.MyArraySizeException;


public class Main {
    public static void main(String[] args) {
        String[][] validArray = {
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"}
        };

        String[][] invalidSizeArray = {
                {"5", "5", "5"},
                {"5", "5", "5"},
                {"7", "5", "9"}
        };

        String[][] invalidDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "seven", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        ArrayProcessor processor = new ArrayProcessor();

        try {
            int result = processor.processArray(validArray);
            System.out.println("Сумма элементов массива: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            processor.processArray(invalidSizeArray);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            processor.processArray(invalidDataArray);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }
}
