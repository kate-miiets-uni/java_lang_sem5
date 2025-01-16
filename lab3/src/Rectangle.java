// Клас Rectangle, який успадковується від класу Shape
class Rectangle extends Shape {
    // Поля для зберігання ширини і висоти прямокутника
    private double width;
    private double height;

    // Конструктор для ініціалізації прямокутника
    public Rectangle(String shapeColor, double width, double height) {
        super(shapeColor);
        this.width = width;
        this.height = height;
    }

    // Метод для обчислення площі прямокутника
    @Override
    public double calcArea() {
        return width * height;
    }

    // Метод для побудови прямокутника
    @Override
    public void draw() {
        System.out.println("Drawing Rectangle");
    }

    // Перевизначений метод toString()
    @Override
    public String toString() {
        return "Rectangle color: " + shapeColor + ", width: " + width + ", height: " + height + ", area: " + calcArea();
    }
}