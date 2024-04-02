package YandexTren.Training5.ThirdWeek.Problem3C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        int arrLength = Integer.parseInt(scan.readLine());

        String[] tempArrStr = scan.readLine().split(" ");

        Integer[] numbersArr = new Integer[arrLength];
        for (int i = 0; i < arrLength; i++) {
            numbersArr[i] = Integer.parseInt(tempArrStr[i]);
        }
        Arrays.sort(numbersArr);

        if (arrLength == 1) {
            System.out.println(0);
            return;
        }

        LinkedHashMap<Integer, Integer> sameNumbersLengthDict = new LinkedHashMap<>();
        int leftPos = numbersArr[0];
        sameNumbersLengthDict.put(leftPos, 1);

        for (int i = 1; i < arrLength; i++) {
            if (numbersArr[i] - leftPos == 0) {
                sameNumbersLengthDict.put(numbersArr[i], sameNumbersLengthDict.get(numbersArr[i]) + 1);
            }
            else {
                sameNumbersLengthDict.put(numbersArr[i], 1);
                leftPos = numbersArr[i];
            }
        }
        int lengthOfGoodRange;
        int maxLengthOfGoodRange = sameNumbersLengthDict.get(numbersArr[0]);
        Integer[] keySet = sameNumbersLengthDict.keySet().toArray(new Integer[0]);
        int leftKey = keySet[0];
        for (int i = 1; i < sameNumbersLengthDict.size(); i++) {
            if (keySet[i] - leftKey == 1) {
                lengthOfGoodRange = sameNumbersLengthDict.get(leftKey) + sameNumbersLengthDict.get(keySet[i]);
                maxLengthOfGoodRange = Math.max(maxLengthOfGoodRange, lengthOfGoodRange);
                leftKey = keySet[i];
            }
            else {
                lengthOfGoodRange = sameNumbersLengthDict.get(leftKey);
                maxLengthOfGoodRange = Math.max(maxLengthOfGoodRange, lengthOfGoodRange);
                leftKey = keySet[i];
            }
        }
        System.out.println(arrLength - maxLengthOfGoodRange);
    }
}