package ProblemsLeetCode;
public class Sqrt69 {
    public int mySqrt(int x) {
        long start = 0, end = x, ans = 0, mid;
        while (start <= end) {
            mid = (start + end)/2;
            if (mid * mid == x) {
                return (int) mid;
            }
            else if (mid*mid  > x) {
                end = mid -1;
            }
            else {
                start = mid +1;
                ans = mid;
            }
        }
        return (int) ans;
    }
}