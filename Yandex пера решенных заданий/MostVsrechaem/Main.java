package YandexTren.MostVsrechaem;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String str = "ауыщауы";
        mostVsr(str);
    }
    public static void mostVsr(String str) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        Integer count = 0;
        Integer maxCount = 0;
        Character mostChar = ' ';
        for (int i = 0; i < str.length(); i++) {
            count = map.getOrDefault(str.charAt(i), 0);
            count++;
            if (maxCount < count) {
                maxCount = count;
                mostChar = str.charAt(i);
            }
            map.put(str.charAt(i) , count);
        }
        System.out.println(mostChar + " " +  maxCount);
    }
}
