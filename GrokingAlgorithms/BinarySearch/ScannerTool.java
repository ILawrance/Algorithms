package BinarySearch;
import java.util.Scanner;

public class ScannerTool {
    public static int ReadInteger () {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите число для проверки");
        int scanInt = scan.nextInt();
        scan.close();
        return scanInt;
    }
}