// Абстрактний клас Shape, який реалізує інтерфейс Drawable
abstract class Shape implements Drawable {
    // Поле для зберігання кольору фігури
    protected String shapeColor;

    // Конструктор для ініціалізації кольору фігури
    public Shape(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    // Абстрактний метод для обчислення площі фігури
    public abstract double calcArea();

    // Перевизначений метод toString()
    @Override
    public String toString() {
        return "Shape color is " + shapeColor;
    }
}