package SortingByChoosing;

public class FindExtremIndexes {
    
    public static Integer findIndexOfSmallest(Integer [] arrayInts) {
        Integer min = arrayInts[0];
        Integer minIndex = 0;
        for (int i = 0; i < arrayInts.length; i++) {
            if (arrayInts[i] < min) {
                min = arrayInts[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static Integer findIndexOfBiggest(Integer [] arrayInts) {
        Integer max = arrayInts[0];
        Integer maxIndex = 0;
        for (int i = 0; i<arrayInts.length; i ++) {
            if (arrayInts[i] > max) {
                max = arrayInts[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}