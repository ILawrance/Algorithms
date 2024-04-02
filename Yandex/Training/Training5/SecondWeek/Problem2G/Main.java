package YandexTren.Training5.SecondWeek.Problem2G;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countTests = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < countTests; i++) {                    // Принимает каждый тест
            int arrLength = Integer.parseInt(scan.nextLine());
            String[] temp = scan.nextLine().split(" ");
            int[] numbers = new int[arrLength];
            for (int j = 0; j < arrLength; j++) {                // Значения суем в массив
                numbers[j] = Integer.parseInt(temp[j]);
            }
            if (arrLength == 1) {
                System.out.println(1);
                System.out.println(1);
                continue;
            }
            int maxLength;
            int ansCount = 0;
            boolean isEnd = false;
            StringBuilder ansArrLengths = new StringBuilder();
            for (int j = 0; j < arrLength;) {                     // Начинаем идти с начала массива
                maxLength = numbers[j];                            // Берет максимальную длину как размер каждого элемента
                for (int k = 1; k < maxLength; k++) {         // Проходимся по следующим элементам не более чем на длину maxLength
                    if (j+k >= arrLength) {   // Если мы выходим за грань массива
                        maxLength = k;
                        isEnd = true;
                        break;
                    }
                    if (numbers[j + k] < maxLength) {   // Если меньше следующее число максимальной длины
                        if (k > numbers[j + k]){       // Если да - больше ли количество шажочков чем следующее число
                            maxLength = k;            // Выходим из цикла
                        }
                        else {                      // Если шажочков было больше, можем теперь ограничить длину шажочков длиной след. числа
                            maxLength = numbers[j + k];
                        }
                    }
                }       // Завершили проход следующих элементов
                if (isEnd) {    // если встретили конец
                    ansCount++;
                    ansArrLengths.append(maxLength);
                    break;
                }
                else if (j + 1 >= arrLength) { // Вот тут подумать!!!!!!
                    ansCount++;
                    ansArrLengths.append(1);
                    ansArrLengths.append(" ");
                    break;
                }
                else {     // Стандартное продолжение прохода по всем значениям массива
                    j += maxLength;  // Перешагиваем на длину
                    ansCount++;
                    ansArrLengths.append(maxLength); // добавляем длину в ответ
                    ansArrLengths.append(" ");
                }
            }

            while (ansArrLengths.charAt(ansArrLengths.length()-1) == ' ') {     // подтирание лишних пробелов
                ansArrLengths.deleteCharAt(ansArrLengths.length()-1);
            }
            System.out.println(ansCount);
            System.out.println(ansArrLengths);
        }
        scan.close();
    }
}