package YandexTren.Training5.SecondWeek.Problem2B;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] temp = scan.nextLine().split(" ");
        int sumDays = Integer.parseInt(temp[0]);
        int freshDays = Integer.parseInt(temp[1]);
        temp = scan.nextLine().split(" ");
        scan.close();
        int[] pricesOfFishes = new int[sumDays];
        for (int i = 0; i < sumDays; i ++) {
            pricesOfFishes[i] = Integer.parseInt(temp[i]);
        }
        System.out.println(getProfit(sumDays, pricesOfFishes, freshDays));
    }

    private static int getProfit(int sumDays, int[] pricesOfFishes, int freshDays) {
        int buyPrice;
        int maxPrice = 0;
        int maxProfit = 0;
        for (int i = 0; i < sumDays - 1;) {
            buyPrice = pricesOfFishes[i];
            for (int p = 1; p <= freshDays && i + p < sumDays; p++) {
                if (pricesOfFishes[i + p] > maxPrice) {
                    maxPrice = pricesOfFishes[i + p];
                }
            }
            if (maxProfit < maxPrice - buyPrice) {
                maxProfit = maxPrice - buyPrice;
            }
            i++;
            maxPrice = 0;
        }
        return maxProfit;
    }
}