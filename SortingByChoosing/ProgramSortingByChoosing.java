package SortingByChoosing;

public class ProgramSortingByChoosing {
    public static void main (String [] args) {
        Integer [] arrayForSorting = {2,5,1,7,16,2,9,6,2,1,3,4,8,10};
        Integer [] sortedArray = sortingBySelectDownTop(arrayForSorting);
        for (Integer i : sortedArray) {
            System.out.println(i);
        }
    }

    public static Integer[] sortingBySelectDownTop (Integer [] arrayForSorting) {
        Integer [] sortedArray = new Integer[arrayForSorting.length];
        for (int i = 0; i < arrayForSorting.length; i++) {
            int indexOfSmallest = FindExtremIndexes.findIndexOfSmallest(arrayForSorting);
            sortedArray[i] = arrayForSorting[indexOfSmallest];

            // чтобы это наименьшее число не нашлось потом - заменим на наибольшее
            arrayForSorting[indexOfSmallest] = arrayForSorting[FindExtremIndexes.findIndexOfBiggest(arrayForSorting)];
        }
        return sortedArray;
    }
}