import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Створення масиву фігур
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Rectangle("Red", 5, 10));
        shapes.add(new Circle("Blue", 7));
        shapes.add(new Triangle("Green", 6, 8));
        shapes.add(new Rectangle("Yellow", 4, 9));
        shapes.add(new Circle("Red", 3));
        shapes.add(new Triangle("Blue", 5, 12));
        shapes.add(new Rectangle("Green", 2, 6));
        shapes.add(new Circle("Yellow", 9));
        shapes.add(new Triangle("Red", 7, 10));
        shapes.add(new Rectangle("Blue", 8, 5));

        // Відображення набору даних
        displayShapes(shapes);

        // Обчислення сумарної площі всіх фігур
        double totalArea = calculateTotalArea(shapes);
        System.out.println("\nTotal area of all shapes: " + totalArea);

        // Обчислення сумарної площі фігур заданого виду
        double totalRectangleArea = calculateTotalAreaByType(shapes, Rectangle.class);
        System.out.println("Total area of all rectangles: " + totalRectangleArea);

        // Сортування набору даних за збільшенням площі фігур
        shapes.sort(Comparator.comparingDouble(Shape::calcArea));
        System.out.println("\nShapes sorted by area:");
        displayShapes(shapes);

        // Сортування набору даних за кольором фігур
        shapes.sort(Comparator.comparing(shape -> shape.shapeColor));
        System.out.println("\nShapes sorted by color:");
        displayShapes(shapes);
    }

    // Метод для відображення всіх фігур у списку
    private static void displayShapes(List<Shape> shapes) {
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }

    // Метод для обчислення сумарної площі всіх фігур у списку
    private static double calculateTotalArea(List<Shape> shapes) {
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.calcArea();
        }
        return totalArea;
    }

    // Метод для обчислення сумарної площі фігур заданого типу у списку
    private static double calculateTotalAreaByType(List<Shape> shapes, Class<? extends Shape> type) {
        double totalArea = 0;
        for (Shape shape : shapes) {
            if (type.isInstance(shape)) {
                totalArea += shape.calcArea();
            }
        }
        return totalArea;
    }
}
