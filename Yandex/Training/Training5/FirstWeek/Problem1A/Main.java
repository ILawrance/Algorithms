package YandexTren.Training5.FirstWeek.Problem1A;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String vasya = scan.nextLine();
        String masha = scan.nextLine();
        scan.close();
        String[] vasyaArr = vasya.split(" ");
        String[] mashaArr = masha.split(" ");

        int vasyaStartTree = Integer.parseInt(vasyaArr[0]);
        int vasyaRange = Integer.parseInt(vasyaArr[1]);
        int mashaStartTree = Integer.parseInt(mashaArr[0]);
        int mashaRange = Integer.parseInt(mashaArr[1]);
        int vasyaRightTree = vasyaStartTree + vasyaRange;
        int vasyaLeftTree = vasyaStartTree - vasyaRange;
        int mashaRightTree = mashaStartTree + mashaRange;
        int mashaLeftTree = mashaStartTree - mashaRange;
        int mostLeftTree = Math.min(vasyaLeftTree, mashaLeftTree);
        int mostRightTree = Math.max(vasyaRightTree, mashaRightTree);
        int count = 0;

        for (int i = mostLeftTree; i <= mostRightTree; i++) {
            if (i >= vasyaLeftTree && i <= vasyaRightTree || i >= mashaLeftTree && i <= mashaRightTree ) {
                count++;
            }
        }
        System.out.println(count);
    }
}