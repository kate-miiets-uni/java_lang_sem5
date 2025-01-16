// Клас Triangle, який успадковується від класу Shape
class Triangle extends Shape {
    // Поля для зберігання основи і висоти трикутника
    private double base;
    private double height;

    // Конструктор для ініціалізації трикутника
    public Triangle(String shapeColor, double base, double height) {
        super(shapeColor);
        this.base = base;
        this.height = height;
    }

    // Метод для обчислення площі трикутника
    @Override
    public double calcArea() {
        return 0.5 * base * height;
    }

    // Метод для побудови трикутника
    @Override
    public void draw() {
        System.out.println("Drawing Triangle");
    }

    // Перевизначений метод toString()
    @Override
    public String toString() {
        return "Triangle color: " + shapeColor + ", base: " + base + ", height: " + height + ", area: " + calcArea();
    }
}