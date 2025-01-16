package cages;

import animals.Mammal;
import animals.Zebra;
import animals.Giraffe;

// Клас HoofedCage, який наслідує клас MammalCage для зберігання копитних тварин
public class HoofedCage extends MammalCage {
    // Конструктор класу HoofedCage для ініціалізації максимальної ємності вольєра
    public HoofedCage(int capacity) {
        super(capacity);
    }

    // Метод для додавання копитної тварини до вольєра, перевизначений з класу MammalCage
    @Override
    public void addAnimal(Mammal animal) throws Exception {
        // Перевірка, чи є тварина зеброю або жирафом
        if (!(animal instanceof Zebra) && !(animal instanceof Giraffe)) {
            throw new Exception("Only zebras and giraffes are allowed in Hoofed Cage");
        }
        super.addAnimal(animal);
    }
}
