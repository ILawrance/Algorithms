package YandexCode;

import java.io.*;
import java.util.ArrayList;

public class _1_AvgElement {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String [] numbersIn = reader.readLine().split(" ");
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(Integer.parseInt(numbersIn[0]));
        list.add(Integer.parseInt(numbersIn[1]));
        list.add(Integer.parseInt(numbersIn[2]));
        int min = Math.min(list.get(0), list.get(1));
        min = Math.min(min, list.get(2));
        int max = Math.max(list.get(1), list.get(2));
        max = Math.max(max, list.get(0));
        list.remove((Integer) min);
        list.remove((Integer) max);
        writer.write(String.valueOf(list.get(0)));
        reader.close();
        writer.close();
    }
}
