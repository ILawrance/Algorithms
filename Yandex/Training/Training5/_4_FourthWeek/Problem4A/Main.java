package YandexTren.Training5.FourthWeek.Problem4A;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int arrLength = Integer.parseInt(scan.nextLine());
        String[] tempArr = scan.nextLine().split(" ");
        Integer[] numbers = new Integer[arrLength];
        for (int i = 0; i < arrLength; i++) {
            numbers[i] = Integer.parseInt(tempArr[i]);
        }
        Arrays.sort(numbers);
        int leftBorder = 0;
        int rightBorder = arrLength;
        StringBuilder ans = new StringBuilder();
        int queryCount = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < queryCount; i++) {
            String[] temp = scan.nextLine().split(" ");
            int leftIndex = binSearchLess(numbers, leftBorder, rightBorder, Integer.parseInt(temp[0]));
            int rightIndex = binSearchMore(numbers, leftBorder, rightBorder, Integer.parseInt(temp[1]));
            if (leftIndex < 0) {
                leftIndex = -leftIndex - 1;
            }
            if (rightIndex < 0) {
                rightIndex = -rightIndex - 1;
            }
            int count = rightIndex - leftIndex;
            if (leftIndex < arrLength && numbers[leftIndex] < Integer.parseInt(temp[0])) {
                count--;
            }
            if (rightIndex > 0 && numbers[rightIndex - 1] > Integer.parseInt(temp[1])) {
                count--;
            }
            ans.append(Math.max(0, count));
            ans.append(" ");
        }
        System.out.println(ans);
    }
    public static int binSearchLess(Integer[] numbers, int leftBorder, int rightBorder, int target) {
        int mid;
        while (leftBorder < rightBorder) {
            mid = (leftBorder + rightBorder) / 2;
            if (numbers[mid] >= target) {
                rightBorder = mid;
            } else {
                leftBorder = mid + 1;
            }
        }
        return leftBorder;
    }
    public static int binSearchMore(Integer[] numbers, int leftBorder, int rightBorder, int target) {
        int mid;
        while (leftBorder < rightBorder) {
            mid = (leftBorder + rightBorder) / 2;
            if (numbers[mid] <= target) {
                leftBorder = mid + 1;
            } else {
                rightBorder = mid;
            }
        }
        return leftBorder;
    }
}