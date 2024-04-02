package YandexTren.Training5.FirstWeek.Problem1C;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long stringCount = scan.nextLong();
        long countClicks = 0;
        for (long i = 0; i < stringCount; i ++) {
            long tempStr = scan.nextLong();
            if (tempStr == 0) {
                countClicks +=0;
            }
            else if (tempStr%4 == 0 ) {      // Тут только Таб и нужен, за исключением значений меньше 4.
                countClicks += tempStr/4;
            }
            else if (tempStr%4 > 2) {     // Тут можно юзать бекспейс
                countClicks += (tempStr/4) +1;     // Протабали чуть дальше по пробелам
                countClicks++;                 // Вот он бекспейс
            }
            else {  // Тут можно юзать пробел
                if (tempStr%4 == 2) {
                    countClicks+=2;    // 2 Пробельчика
                }
                else {
                    countClicks++;   // 1 пробельчик
                }
                countClicks += tempStr/4;
            }
        }
        System.out.println(countClicks);
    }
}