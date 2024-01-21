package BinarySearch;

public class BinarySearch {
    public static String Search(int[] ArreyInts, int PredictInt) {
        int low = 0;
        int high = ArreyInts.length - 1; 

        while (low <= high) {
                int mid = (low + high) / 2;
                int guess = ArreyInts[mid];
                if (guess == PredictInt) {
                return "Число " + guess + " Существует" + ", занимает позицию: " + mid;
                }
                else if (guess > PredictInt) {
                high = mid -1;
                }
                else {
                low = mid + 1;
                }
        }
        return "Числа " + PredictInt + " в данном массиве нет";
    }
}