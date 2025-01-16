package animals;

// Клас Eagle, який наслідує клас Bird
public class Eagle extends Bird {
    // Конструктор класу Eagle для ініціалізації імені орла
    public Eagle(String name) {
        super(name);
    }

    // Реалізація методу getType(), який повертає тип тварини
    @Override
    public String getType() {
        return "Eagle";
    }
}
