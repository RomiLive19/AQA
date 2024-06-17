import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVReader {

    public static AppData load(String fileName) {
        AppData data = new AppData();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            // Read header
            String headerLine = reader.readLine();
            if (headerLine != null) {
                data.setHeader(headerLine.split(";"));
            }

            List<int[]> dataList = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(";");
                int[] intValues = Arrays.stream(values)
                        .mapToInt(Integer::parseInt)
                        .toArray();
                dataList.add(intValues);
            }

            int[][] dataArray = new int[dataList.size()][];
            for (int i = 0; i < dataList.size(); i++) {
                dataArray[i] = dataList.get(i);
            }
            data.setData(dataArray);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
