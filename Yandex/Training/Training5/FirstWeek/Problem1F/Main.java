package YandexTren.Training5.FirstWeek.Problem1F;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String countOfNumsStr = scan.nextLine();
        String numbers = scan.nextLine();
        scan.close();
        int countOfNums = Integer.parseInt(countOfNumsStr);
        String[] numbersArr = numbers.split(" ");
        int[] numbersIntArr  = new int[countOfNums];

        for (int i = 0; i < countOfNums; i ++ ) {
            numbersIntArr[i] = Integer.parseInt(numbersArr[i]);
        }

        int result = numbersIntArr[0];
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < countOfNums - 1; i ++) {
            if (result % 2 == 0) {
                if (numbersIntArr[i + 1] % 2 == 0) {
                    result += numbersIntArr[i+1];
                    ans.append("+");
                }
                else {
                    result += numbersIntArr[i+1];
                    ans.append("+");
                }
            }
            else {
                if (numbersIntArr[i + 1] % 2 == 0) {
                    result += numbersIntArr[i+1];
                    ans.append("+");
                }
                else {
                    result *= numbersIntArr[i+1];
                    ans.append("x");
                }
            }

        }
        System.out.println(ans);
    }
}