package YandexTren.Training5.ThirdWeek.Problem3D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Dictionary;
import java.util.Hashtable;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        String[] tempNumbers = scan.readLine().split(" ");
        int countNumbers = Integer.parseInt(tempNumbers[0]);
        int range = Integer.parseInt(tempNumbers[1]);

        Dictionary<String, Integer> numbersAndIndexes = new Hashtable<>();
        tempNumbers = scan.readLine().split(" ");
        numbersAndIndexes.put(tempNumbers[0], 0);

        for (int i = 1; i < countNumbers; i++){
           if (numbersAndIndexes.get(tempNumbers[i]) != null ) {
               if (i  - numbersAndIndexes.get(tempNumbers[i]) <= range) {
                   System.out.println("YES");
                   return;
               }
               numbersAndIndexes.put(tempNumbers[i], i);
           }
           else {
               numbersAndIndexes.put(tempNumbers[i], i);
           }
        }

        System.out.println("NO");
    }
}