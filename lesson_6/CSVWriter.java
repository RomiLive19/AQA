import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

public class CSVWriter {

    public static void save(AppData data, String fileName) {
        try (PrintWriter writer = new PrintWriter(new File(fileName))) {
            writer.println(String.join(";", data.getHeader()));

            for (int[] row : data.getData()) {
                String rowString = Arrays.stream(row)
                        .mapToObj(String::valueOf)
                        .reduce((a, b) -> a + ";" + b)
                        .orElse("");
                writer.println(rowString);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
