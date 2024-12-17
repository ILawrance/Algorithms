package ProblemsLeetCode;
public class _70_ClimbingStairs {
    public int climbStairs(int n) {
        int[] arrCount = new int[n+1];
        arrCount[0] = 1;
        for  (int i = 0; i < arrCount.length; i++) {
            if (i+1 == arrCount.length) {
                return arrCount[i];
            }
            if (i+2 == arrCount.length) {
                return arrCount[i] + arrCount[i+1];
            }
            arrCount[i+1] += arrCount[i];
            arrCount[i+2] += arrCount[i];
        }
        return arrCount[n];
    }
}