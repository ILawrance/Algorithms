package Tinkoff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EntranceSchoolTask3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arrInt = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] line =  br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arrInt[i][j] = Integer.parseInt(line[j]);
            }
        }
        br.close();
        long[] lineSums = new long[n];
        long[] columnSums = new long[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                lineSums[i] += arrInt[i][j];
                columnSums[j] += arrInt[i][j];
            }
        }
        long[][] arrDiffs = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arrDiffs[i][j] = lineSums[i] - columnSums[j];
            }
        }
        long countInterests = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Math.abs(arrDiffs[i][j]) <= arrInt[i][j]) {
                    countInterests++;
                }
            }
        }
        System.out.println(countInterests);
    }
}
