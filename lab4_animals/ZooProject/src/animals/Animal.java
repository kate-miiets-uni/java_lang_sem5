package animals;

import java.io.Serializable;

// Абстрактний клас Animal, який імплементує інтерфейс Serializable
public abstract class Animal implements Serializable {
    // Поле name для зберігання імені тварини
    private String name;

    // Конструктор класу Animal для ініціалізації імені тварини
    public Animal(String name) {
        this.name = name;
    }

    // Метод для отримання імені тварини
    public String getName() {
        return name;
    }

    // Абстрактний метод для отримання типу тварини (буде реалізований у підкласах)
    public abstract String getType();
}
