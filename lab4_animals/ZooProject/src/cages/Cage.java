package cages;

import animals.Animal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// Абстрактний клас Cage, який реалізує інтерфейс Serializable
public abstract class Cage<T extends Animal> implements Serializable {
    // Приватне поле для зберігання максимальної ємності вольєра
    private int capacity;
    // Приватне поле для зберігання списку тварин у вольєрі
    private List<T> animals;

    // Конструктор класу Cage для ініціалізації максимальної ємності та створення списку тварин
    public Cage(int capacity) {
        this.capacity = capacity;
        this.animals = new ArrayList<>();
    }

    // Метод для отримання максимальної ємності вольєра
    public int getCapacity() {
        return capacity;
    }

    // Метод для отримання кількості зайнятих місць у вольєрі
    public int getOccupiedSpace() {
        return animals.size();
    }

    // Метод для додавання тварини до вольєра
    // Викидає виключення, якщо вольєр переповнений
    public void addAnimal(T animal) throws Exception {
        if (animals.size() >= capacity) {
            throw new Exception("Cage is full");
        }
        animals.add(animal);
    }

    // Метод для видалення тварини з вольєра
    // Викидає виключення, якщо тварини немає у вольєрі
    public void removeAnimal(T animal) throws Exception {
        if (!animals.contains(animal)) {
            throw new Exception("Animal not found in cage");
        }
        animals.remove(animal);
    }

    // Метод для отримання списку всіх тварин у вольєрі
    public List<T> getAnimals() {
        return animals;
    }
}
