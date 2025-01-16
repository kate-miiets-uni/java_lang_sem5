public class Main {
    public static void main(String[] args) {

        String wordsTogether = "Сонце, книга, автомобіль горизонт, ентузіазм";
        // Розділяємо рядок на слова за пробілами та комами з пробілами
        String[] wordsSeparate = wordsTogether.split(", | ");

        // Виводимо на консоль розділені слова
        for (String word : wordsSeparate){
            System.out.println(word);

        }

        // Ініціалізуємо допоміжні змінні
        int minWordLength = 100;
        String minWord = "string";

        // Перевіряємо довжину кожного слова
        for (String word : wordsSeparate){
            if (word.length() < minWordLength){
                minWordLength = word.length();
                minWord = word;
            }
        }

        System.out.println("Найменша кількість символів у слові: " + minWord + " букв: "+ minWordLength);
    }
}