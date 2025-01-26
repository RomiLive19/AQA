import java.util.*;


public class PhoneBook {
    private Map<String, List<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void add(String LastName, String Number) {
        phoneBook.putIfAbsent(LastName, new ArrayList<>());
        phoneBook.get(LastName).add(Number);
    }

    public List<String> get(String LastName) {
        return phoneBook.getOrDefault(LastName, Collections.emptyList());
    }
}
