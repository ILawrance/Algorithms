package BinarySearch;

public class ProgramBinarySearch {
    public static void main (String[] args) {

        int[] Arrey = new int[1000];
        for (int i = 0; i<1000; i++) {
            Arrey[i] = i;
        }

        double randomPredict = 1000*Math.random();
        int randomPredictInt = (int) randomPredict;
        int intInConsole = ScannerTool.ReadInteger();

        int [] intInInput = new int[2];
        intInInput[0] = randomPredictInt;
        intInInput[1] = intInConsole;

        String[] MassagesForSearch = new String[2];
        for (int i = 0; i <MassagesForSearch.length; i++) {
         System.out.println(MassagesForSearch[i] = "В массиве " + "Arrey" + " результат поиска числа " + intInInput[i] + " показал:  " + BinarySearch.Search(Arrey, intInInput[i]));
        }
    }
}