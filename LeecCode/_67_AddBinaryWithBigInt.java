package ProblemsLeetCode;
import java.math.BigInteger;
public class _67_AddBinaryWithBigInt {
        public String addBinary(String a, String b) {
            BigInteger num1 = binaryToBigInteger(a);
            BigInteger num2 = binaryToBigInteger(b);
            BigInteger sum = num1.add(num2);
            return bigIntegerToBinary(sum);
        }
        public BigInteger binaryToBigInteger(String binary) {
            BigInteger result = BigInteger.ZERO;
            int n = binary.length(); ///////////   10010100110
            for (int i = 0; i < n; i++) {
                if (binary.charAt(i) == '1') {
                    result = result.add(BigInteger.valueOf(2).pow(n - 1 - i));
                }
            }
            return result;
        }
        public String bigIntegerToBinary(BigInteger num) {
            if (num.equals(BigInteger.ZERO)) {
                return "0";
            }
            StringBuilder sb = new StringBuilder();
            while (!num.equals(BigInteger.ZERO)) {
                sb.append(num.mod(BigInteger.valueOf(2)));
                num = num.divide(BigInteger.valueOf(2));
            }
            return sb.reverse().toString();
        }
}