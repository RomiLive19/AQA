import java.util.*;

public class Utils {
    public static List<Integer> generateRandomNumbers(int count, int min, int max) {
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            numbers.add(random.nextInt(max - min + 1) + min);
        }
        return numbers;
    }

    public static int countEvenNumbers(List<Integer> numbers) {
        int count = 0;
        for (int num : numbers) {
            if (num % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static int countOccurrences(List<String> collection, String target) {
        int count = 0;
        for (String item : collection) {
            if (item.equals(target)) {
                count++;
            }
        }
        return count;
    }

    public static Object getFirstElement(List<String> collection) {
        return collection.isEmpty() ? 0 : collection.get(0);
    }

    public static Object getLastElement(List<String> collection) {
        return collection.isEmpty() ? 0 : collection.get(collection.size() - 1);
    }

    public static List<String> sortStrings(List<String> strings) {
        List<String> sortedStrings = new ArrayList<>(strings);
        Collections.sort(sortedStrings);
        return sortedStrings;

    }
}