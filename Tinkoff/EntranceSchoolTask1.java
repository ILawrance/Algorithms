package Tinkoff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EntranceSchoolTask1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        br.close();
        System.out.println(Summ(n));
    }
    public static long Summ(long n) {
        int start = 100;
        long end = n;
        long sum = 0;
        sum = (start + end) * (end - start + 1) / 2;
        return sum;
    }
}
