package Recursion;

public class CountDown {
    public static void Count(int i) {
        if (i>0) {
            System.out.println(i);
            i--;
            Count(i);
        }
        else {
            System.out.println(i + " Расчет окончен");
        }
    }
}
