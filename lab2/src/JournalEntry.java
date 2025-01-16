import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class JournalEntry {
    private String lastName;
    private String firstName;
    private LocalDate birthDate;
    private String phoneNumber;
    private String address;

    // Конструктор класу JournalEntry
    public JournalEntry (String lastName, String firstName, String birthDate, String phoneNumber, String address){
        this.lastName = lastName;
        this.firstName = firstName;
        setBirthDate(birthDate); // Викликаємо метод setBirthDate для перевірки формату дати
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    // Геттери для доступу до приватних полів класу
    public String getLastName(){
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    // Метод для перевірки правильності введеної дати народження
    private void setBirthDate(String birthDate) throws IllegalArgumentException {
        try{
            this.birthDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Дата народження має бути у форматі dd.MM.yyyy");
        }
    }

    // Метод для форматування інформації про запис у вигляді рядка
    @Override
    public String toString() {
        return "Прізвище: "+ lastName + "\tІм'я:" + firstName + "\tДата народження:" + birthDate + "\tНомер телефону:" + phoneNumber + "\tАдреса:" +address;
    }
}