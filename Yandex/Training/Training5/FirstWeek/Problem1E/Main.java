package YandexTren.Training5.FirstWeek.Problem1E;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] inputArr = input.split(" ");
        StringBuilder ans = new StringBuilder(inputArr[0]);
        long kolichestvoChel = Long.parseLong(inputArr[1]);
        long daysOfGoldFarming = Long.parseLong(inputArr[2]);
        boolean finded = false;

        if ((ans.length() + 1) < Long.toString(kolichestvoChel).length()) {
            System.out.println(-1);
        }
        else if (Long.parseLong(ans.toString()) % kolichestvoChel == 0 ) {
            for (long i = 0; i < daysOfGoldFarming; i++) {
                ans.append("0");
            }
            System.out.println(ans);
        }
        else {
                    for (int k = 0; k < 10; k ++) {
                        if (Long.parseLong(ans.toString() + k) % kolichestvoChel == 0) {
                            finded = true;
                            ans.append(k);
                            break;
                        }
                    }
                    if (!finded) {
                        System.out.println(-1);
                    }
                    else {
                        for (long i = 0; i < daysOfGoldFarming - 1; i++) {
                            ans.append("0");
                        }
                        System.out.println(ans);
                    }
        }
    }
}