import cages.Cage;
import animals.Animal;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Клас Zoo для управління вольєрами та тваринами у зоопарку
public class Zoo {
    // Список вольєрів, які містять різні типи тварин
    private List<Cage<? extends Animal>> cages = new ArrayList<>();

    // Метод для підрахунку загальної кількості тварин у зоопарку
    public int getCountOfAnimals() {
        int count = 0;
        // Проходимо по всіх вольєрах і підсумовуємо кількість зайнятих місць
        for (Cage<? extends Animal> cage : cages) {
            count += cage.getOccupiedSpace();
        }
        return count;
    }

    // Метод для додавання нового вольєра до зоопарку
    public void addCage(Cage<? extends Animal> cage) {
        cages.add(cage);
    }

    // Метод для збереження даних про вольєри та тварин у файл
    public void saveToFile(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(cages);
        }
    }

    // Метод для завантаження даних про вольєри та тварин з файлу
    public void loadFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            cages = (List<Cage<? extends Animal>>) ois.readObject();
        }
    }
}
