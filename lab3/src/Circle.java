// Клас Circle, який успадковується від класу Shape
class Circle extends Shape {
    // Поле для зберігання радіусу кола
    private double radius;

    // Конструктор для ініціалізації кола
    public Circle(String shapeColor, double radius) {
        super(shapeColor);
        this.radius = radius;
    }

    // Метод для обчислення площі кола
    @Override
    public double calcArea() {
        return Math.PI * radius * radius;
    }

    // Метод для побудови кола
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }

    // Перевизначений метод toString()
    @Override
    public String toString() {
        return "Circle color: " + shapeColor + ", radius: " + radius + ", area: " + calcArea();
    }
}