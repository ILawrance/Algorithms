package SoftProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class _1Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/SoftProject/1.txt"));
        String line;
        long counterSummSector = 0;
        while((line = reader.readLine()) != null) {
            HashMap<Character, Integer> map = new HashMap<>();

            // Ограничиваем беготню до последнего тире
            int lastDefisId = -1;
            for (int i = line.length() -1; i > -1; i--) {
                if (line.charAt(i) == '-') {
                    lastDefisId = i;
                    break;
                }
            }

            //Сохраняем контрольную сумму
            int lastSkobkaId = -1;
            for (int i = line.length() -1; i > -1; i--) {
                if (line.charAt(i) == '[') {
                    lastSkobkaId = i;
                    break;
                }
            }

            // Бегаем заполняем мапу
            for (int i = 0; i < lastDefisId; i++) {
                if (line.charAt(i) == '-') {continue;}
                map.put(line.charAt(i), map.getOrDefault(line.charAt(i), 0) + 1);
            }

            // Сортируем ключи по убыванию значений, если значения == то по алфавиту
            List<Character> top5char = map.entrySet().stream().
                    sorted((entry1, entry2) ->
                    {int valueComparison = Integer.compare(entry2.getValue(), entry1.getValue());
                    return valueComparison != 0 ? valueComparison : Character.compare(entry1.getKey(), entry2.getKey());
                    })
                    .limit(5).
                    map(Map.Entry::getKey).
                    toList();

            // Формируем норм строку получившейся контрольной суммы
            StringBuilder stringBuilderResultControlSumm = new StringBuilder();
            stringBuilderResultControlSumm.append("[");
            for (Character character : top5char) {
                stringBuilderResultControlSumm.append(character);
            }
            stringBuilderResultControlSumm.append("]");

            // Строки 1) контрольных сумм и 2) ID сектора
            String controlSumm = line.substring(lastSkobkaId);
            String sectorId = line.substring(lastDefisId + 1, lastSkobkaId);
            long sectorIdLong = Long.parseLong(sectorId);
            String resultControlSumm = stringBuilderResultControlSumm.toString();

            // Подсчет суммы
            if (resultControlSumm.equals(controlSumm)) {
                counterSummSector += sectorIdLong;
            }

            System.out.println(line);
            System.out.println("Получившаяся контрольная сумма = "  + resultControlSumm);
            System.out.println("Контрольная сумма = " + controlSumm);
            System.out.println("id сектора = " + sectorIdLong);
            System.out.println("Итоговая сумма айди секторов = " + counterSummSector);
            System.out.println(isAlphabetOrder(controlSumm));
            System.out.println(isAlphabetOrder(resultControlSumm));
            System.out.println(" ");
            System.out.println(isAlphabetOrder("[oarel]"));

        }
        reader.close();
    }

    public static boolean isAlphabetOrder(String str) {
        char prevChar = str.charAt(1);
        for (int i = 2; i < str.length()-1; i++) {
            char currChar = str.charAt(i);
            if (currChar < prevChar) {
                return false;
            }
            prevChar = currChar;
        }
        return true;
    }
}

// 19894 с проверкой
// 174145 без проверки