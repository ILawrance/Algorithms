package YandexTren.Training5.SecondWeek.Problem2C;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countBichovka = Integer.parseInt(scan.nextLine());
        String[] tempLength = scan.nextLine().split(" ");
        int[] lengthArr = new int[countBichovka];
        int sumLength = 0;
        int maxLength = 0;
        for (int i = 0; i < lengthArr.length; i ++) {
            lengthArr[i] = Integer.parseInt(tempLength[i]);
            sumLength += lengthArr[i];
            if (lengthArr[i] > maxLength) {
                maxLength = lengthArr[i];
            }
        }
        if ( sumLength - maxLength == maxLength ) {
            System.out.println(sumLength);
        }
        else if (maxLength - (sumLength - maxLength) > 0){
            System.out.println(maxLength - (sumLength - maxLength));
        }
        else {
            System.out.println(sumLength);
        }
    }
}