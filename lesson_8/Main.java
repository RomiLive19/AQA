/**
 * Lesson_8
 **/

import java.util.Map;


public class Main {
    public static void main(String[] args) {
        System.out.println("Список слов:");
        String[] words = {
                "один", "два", "три ", "четыре", "пять", "шесть", "два", "один", "два", "пять", "шесть", "один", "два"
        };

        Map<String, Integer> wordCount = UniqueWords.countWords(words);
        System.out.println("Список уникальных слов:");
        for (String word : wordCount.keySet()) {
            System.out.println(word);
        }
        System.out.println();

        System.out.println("Встречающиеся слова:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
        System.out.println("Телефонный справочник:");
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "+37529123-12-12");
        phoneBook.add("Петров", "+37529123-13-13");
        phoneBook.add("Сидлоров", "+37529123-14-14");

        System.out.println("Номер Иванова:" + phoneBook.get("Иванов"));
        System.out.println("Номер Петрова:" + phoneBook.get("Петров"));
        System.out.println("Номер Сидлорова:" + phoneBook.get("Сидлоров"));

    }
}