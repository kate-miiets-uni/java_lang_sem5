import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;
import java.util.Random;

public class ForkJoinSum {
    // Поріг для обчислення суми без розподілу
    private static final int THRESHOLD = 20;
    // Розмір масиву
    private static final int ARRAY_SIZE = 1_000_000;

    public static void main(String[] args) {
        // Створення та ініціалізація масиву
        int[] array = new int[ARRAY_SIZE];
        Random random = new Random();
        // Генерація випадкових значень у діапазоні від 0 до 100
        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = random.nextInt(101);
        }

        // Створення ForkJoinPool та обчислення суми
        ForkJoinPool pool = new ForkJoinPool();
        long startTime = System.currentTimeMillis();
        // Запуск основної задачі SumTask для обчислення суми
        Long result = pool.invoke(new SumTask(array, 0, ARRAY_SIZE));
        long endTime = System.currentTimeMillis();

        // Вивід результату
        System.out.println("Сума всіх елементів масиву: " + result);
        System.out.println("Час виконання: " + (endTime - startTime) + " мс");
    }

    // Рекурсивна задача для обчислення суми елементів масиву
    static class SumTask extends RecursiveTask<Long> {
        private int[] array;
        private int start;
        private int end;

        // Конструктор задачі SumTask
        SumTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            int length = end - start;
            if (length < THRESHOLD) {
                // Якщо розмір підмасиву менше порогу, обчислюємо суму без розподілу
                long sum = 0;
                for (int i = start; i < end; i++) {
                    sum += array[i];
                }
                return sum;
            } else {
                // Поділ масиву на дві частини та виконання підзадач
                int mid = start + (length / 2);
                SumTask leftTask = new SumTask(array, start, mid);
                SumTask rightTask = new SumTask(array, mid, end);
                leftTask.fork(); // Запуск лівої підзадачі в окремому потоці
                Long rightResult = rightTask.compute(); // Виконання правої підзадачі в поточному потоці
                Long leftResult = leftTask.join(); // Отримання результату лівої підзадачі
                return leftResult + rightResult; // Сума результатів підзадач
            }
        }
    }
}
