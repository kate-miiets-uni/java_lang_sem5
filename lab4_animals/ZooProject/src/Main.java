import animals.*;
import cages.*;

public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();

        // Створення вольєрів
        Cage<Lion> lionCage = new LionCage(2);
        Cage<Bird> birdCage = new BirdCage(3);
        Cage<Mammal> hoofedCage = new HoofedCage(4);

        // Додавання вольєрів до зоопарку
        zoo.addCage(lionCage);
        zoo.addCage(birdCage);
        zoo.addCage(hoofedCage);

        // Додавання тварин до вольєрів
        try {
            lionCage.addAnimal(new Lion("Simba"));
            lionCage.addAnimal(new Lion("Mufasa"));

            birdCage.addAnimal(new Eagle("Eagle 1"));
            birdCage.addAnimal(new Eagle("Eagle 2"));

            hoofedCage.addAnimal(new Zebra("Zebra 1"));
            hoofedCage.addAnimal(new Giraffe("Giraffe 1"));

            System.out.println("Total animals in zoo: " + zoo.getCountOfAnimals());

            // Збереження тварин у файл
            zoo.saveToFile("zoo_data.ser");

            // Читання тварин з файлу
            zoo.loadFromFile("zoo_data.ser");
            System.out.println("Total animals in zoo after loading from file: " + zoo.getCountOfAnimals());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
