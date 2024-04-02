package YandexTren.Training5.SecondWeek.Problem2H;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] temp = scan.nextLine().split(" ");
        int countRaces = Integer.parseInt(temp[0]), countClasses = Integer.parseInt(temp[1]);
        int[][] stats = new int[countRaces + 1][countClasses + 1];
        int[] maxesInStrings = new int[countRaces + 1], maxesInColumns = new int[countClasses + 1];
        int firstMax = 0, secondMax = 0;
        int[] indexFirstMax = new int[2], indexSecondMax = new int[2];
        int[] sumInStrings = new int[countRaces + 1], sumInColumns = new int[countClasses + 1];


        for (int i = 1; i < countRaces + 1; i ++) {
            temp = scan.nextLine().split(" ");
            for (int j = 1; j < countClasses + 1; j++) {
                stats[i][j] = Integer.parseInt(temp[j-1]);
                sumInStrings[i] += stats[i][j];  // суммируем строки
                sumInColumns[j] += stats[i][j];  // суммируем столбцы
                if (stats[i][j] >= firstMax) {
                    secondMax = firstMax;
                    indexSecondMax[0] = indexFirstMax[0];
                    indexSecondMax[1] = indexFirstMax[1];
                    firstMax = stats[i][j];
                    indexFirstMax[0] = i;
                    indexFirstMax[1] = j;
                }
                else if (stats[i][j] <= firstMax && stats[i][j] >= secondMax) {
                    secondMax = stats[i][j];
                    indexSecondMax[0] = i;
                    indexSecondMax[1] = j;
                }
            }
        }
        System.out.println("Сумма чисел по строке 2 = " + sumInStrings[2] + ", а по столбцу 2 =  " + sumInColumns[2] + ".");
        System.out.println("first Biggest = " + firstMax + ". on indexes = string: " + indexFirstMax[0] + " column: " + indexFirstMax[1] );
        System.out.println("Second Biggest = " + secondMax + ". on indexes = string: " + indexSecondMax[0] + " column: " + indexSecondMax[1] );
        /*
         2 3
         2 4 6
         3 1 1
        */
    }
}







/*for (int i = 1; i < countRaces+1; i++) {
            for (int j = 1; j <countClasses +1; j++) {
                System.out.print(stats[i][j] + " ");
            }
            System.out.println(" ");
        }*/