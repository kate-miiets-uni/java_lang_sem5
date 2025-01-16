package cages;

import animals.Mammal;

// Клас MammalCage, який наслідує клас Cage з узагальненим типом Mammal
public class MammalCage extends Cage<Mammal> {
    // Конструктор класу MammalCage для ініціалізації максимальної ємності вольєра
    public MammalCage(int capacity) {
        super(capacity);
    }
}
