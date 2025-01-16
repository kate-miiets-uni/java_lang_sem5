package animals;

// Клас Giraffe, який наслідує клас Hoofed
public class Giraffe extends Hoofed {
    // Конструктор класу Giraffe для ініціалізації імені жирафа
    public Giraffe(String name) {
        super(name);
    }

    // Реалізація методу getType(), який повертає тип тварини
    @Override
    public String getType() {
        return "Giraffe";
    }
}
