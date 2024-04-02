package ProblemsLeetCode;
public class PlusOne66 {
    public int[] plusOne(int[] digits) {
        if (isOnly9(digits)) {
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            return ans;
        }
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        return digits;
    }
    public boolean isOnly9(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                return false;
            }
        }
        return true;
    }
}