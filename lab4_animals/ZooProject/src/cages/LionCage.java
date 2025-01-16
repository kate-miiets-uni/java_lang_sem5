package cages;

import animals.Lion;

// Клас LionCage, який наслідує клас Cage для зберігання левів
public class LionCage extends Cage<Lion> {
    // Конструктор класу LionCage для ініціалізації максимальної ємності вольєра
    public LionCage(int capacity) {
        super(capacity);
    }

    // Метод для додавання лева до вольєра, перевизначений з класу Cage
    @Override
    public void addAnimal(Lion animal) throws Exception {
        super.addAnimal(animal);
    }
}
