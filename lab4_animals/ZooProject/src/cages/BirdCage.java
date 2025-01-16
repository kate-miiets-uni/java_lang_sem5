package cages;

import animals.Bird;

// Клас BirdCage, який наслідує клас Cage з узагальненим типом Bird
public class BirdCage extends Cage<Bird> {
    // Конструктор класу BirdCage для ініціалізації максимальної ємності вольєра
    public BirdCage(int capacity) {
        super(capacity);
    }
}
