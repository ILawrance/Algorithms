package YandexTren.Training5.SecondWeek.Problem2E;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long sumBerries = Long.parseLong(scan.nextLine());
        Dictionary<Long, Long[]> berriesGood = new Hashtable<>();
        Dictionary<Long, Long[]> berriesBaad = new Hashtable<>();
        Dictionary<Long, Long[]> berriesNeutral = new Hashtable<>();
        long sumUpGoodBerrys = 0L;
        long sumDownGoodBerrus = 0L;
        String[] tempBarriStrArr;
        Long[] tempBerriLongArr = new Long[2];
        for (long i = 1; i <= sumBerries; i++) {
            tempBarriStrArr = scan.nextLine().split(" ");
            tempBerriLongArr[0] = Long.parseLong(tempBarriStrArr[0]);
            tempBerriLongArr[1] = Long.parseLong(tempBarriStrArr[1]);

            if (tempBerriLongArr[1] > tempBerriLongArr[0]) {
                berriesBaad.put(i, new Long[]{tempBerriLongArr[0], tempBerriLongArr[1]}); // В словарь плохих ягод
            }
            else if (tempBerriLongArr[0].equals(tempBerriLongArr[1])){
                berriesNeutral.put(i, new Long[]{tempBerriLongArr[0], tempBerriLongArr[1]}); // В словарь нейтральных ягод ягод
            }
            else {
                berriesGood.put(i, new Long[]{tempBerriLongArr[0], tempBerriLongArr[1]}); // Записали ягодны в словарь выгодных ягод
                sumUpGoodBerrys += tempBerriLongArr[0];
                sumDownGoodBerrus += tempBerriLongArr[1];
            }
        }
        Enumeration<Long> numbersBadBarryEnum = berriesBaad.keys();  // В плохих ищем максимально высокую
        Long numberBadBarryMaxBad = 0L;
        long maxUpBad;
        if (!berriesBaad.isEmpty()) {
            numberBadBarryMaxBad = numbersBadBarryEnum.nextElement();
            maxUpBad = berriesBaad.get(numberBadBarryMaxBad)[0];
            for (long i = 1; i <= sumBerries; i ++) {
                if (berriesBaad.get(i) != null) {
                    if (berriesBaad.get(i)[0] >= maxUpBad) {
                        maxUpBad = berriesBaad.get(i)[0];
                        numberBadBarryMaxBad = i;
                    }
                }
            }
        }
        // В хороших ищем максимально выгодную,
        // в плане, если ее добавить последней,
        // то общая сумма без ее вычета будет самый выгодной
        long numberGoodBarryProfit = 0L;
        long maxGoodBProfit = 0L;
        if (!berriesGood.isEmpty()) {
            long[] goodKeys = new long[berriesGood.size() + 1];
            int j = 1;
            for (long i = sumBerries; i >= 1; i--) {
                if (!berriesGood.isEmpty()) {
                    if (berriesGood.get(i) != null) {
                        goodKeys[j] = i;
                        j++;
                    }
                }
            }
            long tempSum = 0L;
            for (int i = 1; i < goodKeys.length; i++ ) {
                long key = goodKeys[i];
                tempSum = sumUpGoodBerrys - sumDownGoodBerrus + berriesGood.get(key)[1];
                if (tempSum > maxGoodBProfit ) {
                    maxGoodBProfit = tempSum;
                    numberGoodBarryProfit = key;
                }
            }
        }

        StringBuilder ansSequence = new StringBuilder();
        Long maxHeight = 0L;
        Long currentHeight = 0L;
        // Начали!!
        // Все, все, все ягоды
        for (long i = 1; i < numberGoodBarryProfit; i++) {   // Хорошие ягоды до максПРОФИТНОЙ
            if (berriesGood.get(i) != null) {
                currentHeight += berriesGood.get(i)[0];
                if (currentHeight > maxHeight) {
                    maxHeight = currentHeight;
                }
                currentHeight -= berriesGood.get(i)[1];
                ansSequence.append(i);
                ansSequence.append(" ");
            }
        }
        for (long i = numberGoodBarryProfit + 1; i <= sumBerries; i++) { // Хорошие ягоды после ультрапрофитной
            if (berriesGood.get(i) != null) {
                currentHeight += berriesGood.get(i)[0];
                if (currentHeight > maxHeight) {
                    maxHeight = currentHeight;
                }
                currentHeight -= berriesGood.get(i)[1];
                ansSequence.append(i);
                ansSequence.append(" ");
            }
        }
        if (berriesGood.get(numberGoodBarryProfit) != null) { // Самая ультрапрофитная
            currentHeight += berriesGood.get(numberGoodBarryProfit)[0];
            if (currentHeight > maxHeight) {
                maxHeight = currentHeight;
            }
            currentHeight -= berriesGood.get(numberGoodBarryProfit)[1];
            ansSequence.append(numberGoodBarryProfit);
            ansSequence.append(" ");
        }
        for (long i = 1; i <= sumBerries; i++) {   // Нейтральные все
            if (berriesNeutral.get(i) != null) {
                currentHeight += berriesNeutral.get(i)[0];
                if (currentHeight > maxHeight) {
                    maxHeight = currentHeight;
                }
                currentHeight -= berriesNeutral.get(i)[1];
                ansSequence.append(i);
                ansSequence.append(" ");
            }
        }
        if (berriesBaad.get(numberBadBarryMaxBad) != null) {  // И самую высокую плохую
            currentHeight += berriesBaad.get(numberBadBarryMaxBad)[0];
            if (currentHeight > maxHeight) {
                maxHeight = currentHeight;
            }
            ansSequence.append(numberBadBarryMaxBad);
            ansSequence.append(" ");
        }

        for (long i = 1; i < numberBadBarryMaxBad; i++) {  // все плохие до той самой
            if (berriesBaad.get(i) != null) {
                ansSequence.append(i);
                ansSequence.append(" ");
            }
        }
        for (long i = numberBadBarryMaxBad + 1; i <= sumBerries; i++) { // все плохие после той самой
            if (berriesBaad.get(i) != null) {
                ansSequence.append(i);
                ansSequence.append(" ");
            }
        }
        while (ansSequence.charAt(ansSequence.length()-1) == ' ') {
            ansSequence.deleteCharAt(ansSequence.length()-1);
        }
        System.out.println(maxHeight);
        System.out.println(ansSequence);
    }
}