import cages.*;
import animals.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class ZooTest {
    // Тест для перевірки додавання тварин до вольєра
    @Test
    public void testAddAnimalToCage() throws Exception {
        LionCage lionCage = new LionCage(2);
        Lion simba = new Lion("Simba");
        Lion mufasa = new Lion("Mufasa");

        // Додаємо тварин до вольєра
        lionCage.addAnimal(simba);
        lionCage.addAnimal(mufasa);

        // Перевіряємо, що кількість зайнятих місць у вольєрі дорівнює 2
        assertEquals(2, lionCage.getOccupiedSpace());
    }

    // Тест для перевірки додавання тварин до повного вольєра
    @Test(expected = Exception.class)
    public void testAddAnimalToFullCage() throws Exception {
        LionCage lionCage = new LionCage(1);
        Lion simba = new Lion("Simba");
        Lion mufasa = new Lion("Mufasa");

        // Додаємо першу тварину до вольєра
        lionCage.addAnimal(simba);
        // Додаємо другу тварину до повного вольєра (це викличе виключення)
        lionCage.addAnimal(mufasa);
    }

    // Тест для перевірки додавання неправильної тварини до вольєра для левів
    @Test(expected = Exception.class)
    public void testAddWrongAnimalToLionCage() throws Exception {
        LionCage lionCage = new LionCage(2);
        Zebra zebra = new Zebra("Stripe");

        // Спроба додати зебру до вольєра для левів (це викличе виключення)
        // lionCage.addAnimal(zebra);
    }

    // Тест для перевірки видалення тварини з вольєра
    @Test
    public void testRemoveAnimalFromCage() throws Exception {
        LionCage lionCage = new LionCage(2);
        Lion simba = new Lion("Simba");

        // Додаємо тварину до вольєра
        lionCage.addAnimal(simba);
        // Видаляємо тварину з вольєра
        lionCage.removeAnimal(simba);

        // Перевіряємо, що кількість зайнятих місць у вольєрі дорівнює 0
        assertEquals(0, lionCage.getOccupiedSpace());
    }

    // Тест для перевірки видалення неіснуючої тварини з вольєра
    @Test(expected = Exception.class)
    public void testRemoveNonExistentAnimalFromCage() throws Exception {
        LionCage lionCage = new LionCage(2);
        Lion simba = new Lion("Simba");

        // Спроба видалити тварину, якої немає у вольєрі (це викличе виключення)
        lionCage.removeAnimal(simba);
    }

    // Тест для перевірки кількості тварин у зоопарку
    @Test
    public void testZooAnimalCount() throws Exception {
        Zoo zoo = new Zoo();
        Cage<Lion> lionCage = new LionCage(2);
        Cage<Bird> birdCage = new BirdCage(3);

        // Додаємо тварин до відповідних вольєрів
        lionCage.addAnimal(new Lion("Simba"));
        lionCage.addAnimal(new Lion("Mufasa"));
        birdCage.addAnimal(new Eagle("Eagle 1"));

        // Додаємо вольєри до зоопарку
        zoo.addCage(lionCage);
        zoo.addCage(birdCage);

        // Перевіряємо, що кількість тварин у зоопарку дорівнює 3
        assertEquals(3, zoo.getCountOfAnimals());
    }
}