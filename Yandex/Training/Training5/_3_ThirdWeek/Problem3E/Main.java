package YandexTren.Training5.ThirdWeek.Problem3E;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        scan.readLine();
        String[] temp = scan.readLine().split(" ");
        Set<String> firstList = new HashSet<>(List.of(temp));
        scan.readLine();
        temp = scan.readLine().split(" ");
        Set<String> secondList = new HashSet<>(List.of(temp));
        scan.readLine();
        temp = scan.readLine().split(" ");
        Set<String> thirdList = new HashSet<>(List.of(temp));

        Set<String> firstListRetainWithSecond =  new HashSet<>(firstList);
        Set<String> firstListRetainWithThird =  new HashSet<>(firstList);
        firstListRetainWithSecond.retainAll(secondList);
        firstListRetainWithThird.retainAll(thirdList);

        Set<String> secondListRetainWithThird =  new HashSet<>(secondList);
        secondListRetainWithThird.retainAll(thirdList);

        Set<String> UnitedLists = new HashSet<>();
        UnitedLists.addAll(firstListRetainWithSecond);
        UnitedLists.addAll(firstListRetainWithThird);
        UnitedLists.addAll(secondListRetainWithThird);

        List<String> UnitedListsList = new LinkedList<>(UnitedLists);
        UnitedListsList.sort(new NumericStringComparator());
        System.out.println(String.join(" ", UnitedListsList));
    }
    public static class NumericStringComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            int num1 = Integer.parseInt(s1);
            int num2 = Integer.parseInt(s2);
            return Integer.compare(num1, num2);
        }
    }
}