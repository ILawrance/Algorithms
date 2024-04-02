package YandexTren.Training5.FirstWeek.Problem1H;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] dataStr = scan.nextLine().split(" ");
        int length = Integer.parseInt(dataStr[0]);
        int kirilStart = Integer.parseInt(dataStr[1]);
        int kirilSpeed = Integer.parseInt(dataStr[2]);
        int antonStart = Integer.parseInt(dataStr[3]);
        int antonSpeed = Integer.parseInt(dataStr[4]);

        double kirilRangeFromStart = Math.abs(kirilStart);
        double antonRangeFromStart = Math.abs(antonStart);
        double kirilRangeToStart = length - kirilRangeFromStart;
        double antonRangeToStart = length - antonRangeFromStart;

        if ( (Math.abs(kirilSpeed) == 0 && 0 == Math.abs(antonSpeed)) && 
                !sameRange(kirilRangeFromStart, antonRangeFromStart, kirilRangeToStart, antonRangeToStart)  )  {
            System.out.println("NO");
        }
        else {
            System.out.println("YES");
        }

    }
    private static boolean sameRange(double kirilRangeFromStart, double antonRangeFromStart, double kirilRangeToStart, double antonRangeToStart) {
        return kirilRangeFromStart == antonRangeFromStart ||
                kirilRangeFromStart == antonRangeToStart ||
                kirilRangeToStart == antonRangeFromStart ||
                kirilRangeToStart == antonRangeToStart;
    }
}
