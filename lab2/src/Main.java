import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    // Список для зберігання всіх записів журналу
    private static List<JournalEntry> journal = new ArrayList<>();
    // Регулярні вирази для перевірки кирилиці та номера телефону
    private static final Pattern CYRILLIC_PATTERN = Pattern.compile("[\\p{IsCyrillic}\\s]+");
    private static final Pattern PHONE_PATTERN = Pattern.compile("\\d{10,}");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Меню для вибору дії користувачем
            System.out.println("1. Додати запис\n2. Відобразити всі записи\n3. Вийти");
            System.out.print("Виберіть опцію: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addJournalEntry(scanner); // Додавання нового запису
                    break;
                case "2":
                    displayJournalEntries(); // Відображення всіх записів
                    break;
                case "3":
                    System.exit(0); // Завершення програми
                    break;
                default:
                    System.out.println("Невірна опція. Спробуйте ще раз.");
            }
        }
    }

    // Метод для додавання нового запису до журналу
    private static void addJournalEntry(Scanner scanner) {
        try {
            // Введення та перевірка прізвища студента
            System.out.print("Введіть прізвище студента (лише кирилицею): ");
            String lastName = scanner.nextLine();
            while (!CYRILLIC_PATTERN.matcher(lastName).matches()) {
                System.out.println("Прізвище повинно бути введено кирилицею. Спробуйте ще раз.");
                lastName = scanner.nextLine();
            }

            // Введення та перевірка імені студента
            System.out.print("Введіть ім'я студента (лише кирилицею): ");
            String firstName = scanner.nextLine();
            while (!CYRILLIC_PATTERN.matcher(firstName).matches()) {
                System.out.println("Ім'я повинно бути введено кирилицею. Спробуйте ще раз.");
                firstName = scanner.nextLine();
            }

            // Введення дати народження студента
            System.out.print("Введіть дату народження студента (dd.MM.yyyy): ");
            String birthDate = scanner.nextLine();

            System.out.print("Введіть телефон студента (не менше 10 цифр): ");
            String phoneNumber = scanner.nextLine();
            while (!PHONE_PATTERN.matcher(phoneNumber).matches()) {
                System.out.println("Номер телефону повинен містити не менше 10 цифр. Спробуйте ще раз.");
                phoneNumber = scanner.nextLine();
            }

            // Введення домашньої адреси
            System.out.print("Введіть домашню адресу (лише кирилицею, вулиця, будинок, квартира): ");
            String address = scanner.nextLine();

            // Створення нового запису та додавання його до журналу
            JournalEntry entry = new JournalEntry(lastName, firstName, birthDate, phoneNumber, address);
            journal.add(entry);
            System.out.println("Запис успішно додано.");
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage() + " Спробуйте ще раз.");
        }
    }

    // Метод для відображення всіх записів у журналі
    private static void displayJournalEntries() {
        if (journal.isEmpty()) {
            System.out.println("Журнал порожній.");
        } else {
            System.out.println("Всі записи журналу:");
            for (JournalEntry entry : journal) {
                System.out.println(entry);
            }
        }
    }
}
