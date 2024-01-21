import java.util.Scanner;

public class Zadacha1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        int[] arrNumbers = new int[count];
        boolean haveOne = false;
        for (int i = 0; i < count; i++ ) {
            arrNumbers[i] = scan.nextInt();

            if (arrNumbers[i] == 1) {
                haveOne = true;
            }
        }
        scan.close();
        if (!haveOne) {
            System.out.println(0);
        }
        else {
            
            int min = 1;
            int ans = 0;
            int i = 0;
            boolean haveMin = false;
            int len = 0;
            boolean isFail = false;
            while (i < count - 1) {
                if (arrNumbers[i] < min ) {
                    isFail = true;
                    break;
                }
                if (arrNumbers[i] > min ) {
                    len++;
                    i++;
                }
                if (arrNumbers[i] == min && !haveMin) {
                        min++;
                        ans++;
                        i++;
                        len++;
                        haveMin = true;
                }
                if (haveMin && arrNumbers[i] == min ) {
                    if (len == 1) {
                        len++;
                        i++;
                    }
                }
                if (len > 1 && haveMin) {
                    len = 0;
                    haveMin = false;
                }
            }
            if (len == 0 && arrNumbers[count-1] == min && !isFail) {
                ans++;
            }
            System.out.println(ans);
        }
    }
}
