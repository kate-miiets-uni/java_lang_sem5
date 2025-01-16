package animals;

// Клас Lion, який наслідує клас Mammal
public class Lion extends Mammal {
    // Конструктор класу Lion для ініціалізації імені лева
    public Lion(String name) {
        super(name);
    }

    // Реалізація методу getType(), який повертає тип тварини
    @Override
    public String getType() {
        return "Lion";
    }
}
