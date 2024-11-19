package Tinkoff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EntranceSchoolTask2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long sec = Integer.parseInt(br.readLine());
        br.close();
        long result = wave(sec);
        if (result == 0) {
            result = 1;
            System.out.println(result);
        }
        else {
            System.out.println(result);
        }
    }

    public static long wave(long sec) {
        int magicNumber = 4;
        return magicNumber * (sec - 1);
    }
}
