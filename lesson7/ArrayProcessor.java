import lesson7.MyArrayDataException;
import lesson7.MyArraySizeException;

public class ArrayProcessor {
    public int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException("Массив размером 4x4.");
        }
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Массив размером 4x4.");

            }
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверные данные находятся в строке: [" + (i + 1) + "] столбце: [" + (j + 1) + "] массива");
                }
            }
        }
        return sum;
    }
}
