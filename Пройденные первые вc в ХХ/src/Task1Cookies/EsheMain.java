package Task1;
import java.util.Arrays;
import java.util.Scanner;

public class EsheMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Считываем количество мест и количество часов
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        // Создаем массив для хранения количества печенек в каждом месте
        int[] cookies = new int[N];

        // Считываем количество печенек в каждом месте
        for (int i = 0; i < N; i++) {
            cookies[i] = scanner.nextInt();
        }

        // Сортируем массив с количеством печенек по возрастанию
        Arrays.sort(cookies);

        // Инициализируем переменные для минимального и максимального значения K
        int minK = 0;
        int maxK = cookies[N - 1];

        // Итеративно пробуем разные значения K в диапазоне от минимального до максимального
        while (minK <= maxK) {
            int midK = (minK + maxK) / 2; // Среднее значение K

            // Вычисляем общее количество печенек, которые Фёдор может съесть за M часов
            long totalCookies = 0;
            for (int i = N - 1; i >= 0; i--) {
                if (cookies[i] < midK) {
                    break;
                }
                totalCookies += Math.ceil((double) cookies[i] / midK);
            }

            // Если общее количество печенек больше или равно количеству мест * M, уменьшаем K
            // иначе увеличиваем K
            if (totalCookies >= (long) N * M) {
                maxK = midK - 1;
            } else {
                minK = midK + 1;
            }
        }

        // Выводим минимальное значение K
        System.out.println(minK);
        scanner.close();
    }
}