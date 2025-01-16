package animals;

// Клас Zebra, який наслідує клас Hoofed
public class Zebra extends Hoofed {
    // Конструктор класу Zebra для ініціалізації імені зебри
    public Zebra(String name) {
        super(name);
    }

    // Реалізація методу getType(), який повертає тип тварини
    @Override
    public String getType() {
        return "Zebra";
    }
}
