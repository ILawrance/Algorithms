package Tinkoff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class EntranceSchoolTask1BigInt {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger n = new BigInteger(br.readLine());
        BigInteger sum = Summ(n);
        System.out.println(sum);
    }

    public static BigInteger Summ(BigInteger end) {
        BigInteger firstElement = BigInteger.valueOf(100);
        BigInteger numberOfElements = end.subtract(firstElement).add(BigInteger.ONE);
        return numberOfElements.multiply(firstElement.add(end)).divide(BigInteger.TWO);
    }
}
