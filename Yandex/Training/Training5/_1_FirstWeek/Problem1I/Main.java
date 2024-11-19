package YandexTren.Training5.FirstWeek.Problem1I;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Dictionary<Integer, Integer> howManyDaysInMonth = getHowManyDaysInMonsDictionary();
        Dictionary<String, Integer> dayOfWeekNameToNumber = getDayOfWeekNameToNumber();
        Dictionary<Integer, Integer> howRecentDaysIfWeekMeets = getHowRecentDaysIfWeekMeets();
        Dictionary<String, Integer> monthToNumber = getStringIntegerDictionary();
        Dictionary<Integer, String> numbersToWeekDayName = getNumbersToWeekDayName();
        Map<Integer, Integer> weekDaysNumbsAndHowRecentTheyWeekends = getWeekDaysNumbsAndHowRecentTheyWeekends();
        List<Integer[]> monthAndWeekendInIt = new LinkedList<>();

        Scanner scan = new Scanner(System.in);
        int sumWeekends = Integer.parseInt(scan.nextLine());
        int year = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < sumWeekends; i++) {
            String tempStrWeekend = scan.nextLine();
            String[] tempStrWeekendArr = tempStrWeekend.split(" ");
            monthAndWeekendInIt.add(new Integer[]{monthToNumber.get(tempStrWeekendArr[1]), Integer.parseInt(tempStrWeekendArr[0]) } ); //сперва № месяца, потом № дня
        }
        String firstDayInYear = scan.nextLine();
        scan.close();
        int firstDayInYearInt = dayOfWeekNameToNumber.get(firstDayInYear);
        howRecentDaysIfWeekMeets.put(firstDayInYearInt, 53);
        if ((year % 400 == 0) || ((year % 4 == 0) && year % 100 != 0)) {        // Если високосный год
            howManyDaysInMonth.put(2, 29);
            howRecentDaysIfWeekMeets.put(firstDayInYearInt, 53);
            int tempWeekDayNumber = firstDayInYearInt + 1;
            if (tempWeekDayNumber > 7) {
                tempWeekDayNumber -= 7;
            }
            howRecentDaysIfWeekMeets.put(tempWeekDayNumber, 53);
        }
        
        int sumOfDays;
        int dayOfWeekWeekend;
        int ostatok;
        for (Integer[] weekends: monthAndWeekendInIt) {   // Посчитали сколько раз на каких днях недели встречаются праздники
            sumOfDays = 0;
            for (int i = 1; i < weekends[0]; i ++) {   //Сумма дней до месяца праздника
                sumOfDays += howManyDaysInMonth.get(i);
            }
            sumOfDays += weekends[1];   // И дни праздничного месяца
            ostatok = (sumOfDays - 1 ) % 7;
            dayOfWeekWeekend = firstDayInYearInt + ostatok;
            if (dayOfWeekWeekend > 7) {
                dayOfWeekWeekend -= 7;
            }
                weekDaysNumbsAndHowRecentTheyWeekends.put(dayOfWeekWeekend, weekDaysNumbsAndHowRecentTheyWeekends.get(dayOfWeekWeekend)+1);
        }

        int countVihodnih = 0;
        int[] countVihodnihArr = {0,0,0,0,0,0,0};
        for (int i = 1; i < 8; i++) {
            Map<Integer, Integer> weekDaysNumbsAndHowRecentTheyWeekendsTemp = new HashMap<>();
            for (Integer value : weekDaysNumbsAndHowRecentTheyWeekends.values()) {
                weekDaysNumbsAndHowRecentTheyWeekendsTemp.put(weekDaysNumbsAndHowRecentTheyWeekendsTemp.size()+1, value);
            }
            weekDaysNumbsAndHowRecentTheyWeekendsTemp.put(i,0);
            for (int j = 1; j < 8; j++) {
                countVihodnih += weekDaysNumbsAndHowRecentTheyWeekendsTemp.get(j);
            }
            countVihodnih += howRecentDaysIfWeekMeets.get(i);
            countVihodnihArr[i - 1] = countVihodnih;
            countVihodnih =  0;
        }
        int maxVihodnih = 0;
        int minVihodnih = countVihodnihArr[0];
        int indexMaxV = 1;
        int indexMinV = 1;
        for (int i = 1; i < 8; i ++) {
            if (countVihodnihArr[i-1] > maxVihodnih) {
                maxVihodnih = countVihodnihArr[i-1];
                indexMaxV = i;
            }
            if (countVihodnihArr[i-1] < minVihodnih) {
                minVihodnih = countVihodnihArr[i-1];
                indexMinV = i;
            }
        }
        System.out.println(numbersToWeekDayName.get(indexMaxV) + " " + numbersToWeekDayName.get(indexMinV));
    }
    private static Dictionary<String, Integer> getStringIntegerDictionary() {
        Dictionary<String, Integer> monthToNumber = new Hashtable<>();
        monthToNumber.put("January", 1);
        monthToNumber.put("February", 2);
        monthToNumber.put("March", 3);
        monthToNumber.put("April", 4);
        monthToNumber.put("May", 5);
        monthToNumber.put("June", 6);
        monthToNumber.put("July", 7);
        monthToNumber.put("August", 8);
        monthToNumber.put("September", 9);
        monthToNumber.put("October", 10);
        monthToNumber.put("November", 11);
        monthToNumber.put("December", 12);
        return monthToNumber;
    }
    private static Dictionary<Integer, Integer> getHowManyDaysInMonsDictionary() {
        Dictionary<Integer, Integer> howManyDaysInMonth = new Hashtable<>();
        howManyDaysInMonth.put(1, 31);
        howManyDaysInMonth.put(2, 28);
        howManyDaysInMonth.put(3, 31);
        howManyDaysInMonth.put(4, 30);
        howManyDaysInMonth.put(5, 31);
        howManyDaysInMonth.put(6, 30);
        howManyDaysInMonth.put(7, 31);
        howManyDaysInMonth.put(8, 31);
        howManyDaysInMonth.put(9, 30);
        howManyDaysInMonth.put(10, 31);
        howManyDaysInMonth.put(11, 30);
        howManyDaysInMonth.put(12, 31);
        return howManyDaysInMonth;
    }
    private static Dictionary<String, Integer> getDayOfWeekNameToNumber() {
        Dictionary<String, Integer> dayOfWeekNameToNumber = new Hashtable<>();
        dayOfWeekNameToNumber.put("Monday", 1);
        dayOfWeekNameToNumber.put("Tuesday", 2);
        dayOfWeekNameToNumber.put("Wednesday", 3);
        dayOfWeekNameToNumber.put("Thursday", 4);
        dayOfWeekNameToNumber.put("Friday", 5);
        dayOfWeekNameToNumber.put("Saturday", 6);
        dayOfWeekNameToNumber.put("Sunday", 7);
        return dayOfWeekNameToNumber;
    }
    private static Dictionary<Integer, Integer> getHowRecentDaysIfWeekMeets() {
        Dictionary<Integer, Integer> howRecentDaysIfWeekMeets = new Hashtable<>();
        howRecentDaysIfWeekMeets.put(1, 52);
        howRecentDaysIfWeekMeets.put(2, 52);
        howRecentDaysIfWeekMeets.put(3, 52);
        howRecentDaysIfWeekMeets.put(4, 52);
        howRecentDaysIfWeekMeets.put(5, 52);
        howRecentDaysIfWeekMeets.put(6, 52);
        howRecentDaysIfWeekMeets.put(7, 52);
        return howRecentDaysIfWeekMeets;
    }
    private static Dictionary<Integer, String> getNumbersToWeekDayName() {
        Dictionary<Integer, String> numbersToWeekDayName = new Hashtable<>();
        numbersToWeekDayName.put(1, "Monday");
        numbersToWeekDayName.put(2, "Tuesday");
        numbersToWeekDayName.put(3, "Wednesday");
        numbersToWeekDayName.put(4, "Thursday");
        numbersToWeekDayName.put(5, "Friday");
        numbersToWeekDayName.put(6, "Saturday");
        numbersToWeekDayName.put(7, "Sunday");
        return numbersToWeekDayName;
    }
    private static Map<Integer, Integer> getWeekDaysNumbsAndHowRecentTheyWeekends() {
        Map<Integer, Integer> weekDaysNumbsAndHowRecentTheyWeekends = new HashMap<>();
        weekDaysNumbsAndHowRecentTheyWeekends.put(1, 0);
        weekDaysNumbsAndHowRecentTheyWeekends.put(2, 0);
        weekDaysNumbsAndHowRecentTheyWeekends.put(3, 0);
        weekDaysNumbsAndHowRecentTheyWeekends.put(4, 0);
        weekDaysNumbsAndHowRecentTheyWeekends.put(5, 0);
        weekDaysNumbsAndHowRecentTheyWeekends.put(6, 0);
        weekDaysNumbsAndHowRecentTheyWeekends.put(7, 0);
        return weekDaysNumbsAndHowRecentTheyWeekends;
    }
 }