package ProblemsLeetCode;

public class _1493_LongestSubarray {
    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{0,1,1,1,0,1,1,0,1}));
    }
    public static int longestSubarray(int[] nums) {
        int zeroCount = 0;
        int longestWindow = 0;
        // Левая граница
        int start = 0;

        for (int i = 0; i < nums.length; i++) {
            zeroCount += (nums[i] == 0 ? 1 : 0);
            // Уменьшаем окно до лимита
            while (zeroCount > 1) {
                zeroCount -= (nums[start] == 0 ? 1 : 0);
                start++;
            }
            longestWindow = Math.max(longestWindow, i - start);
        }
        return longestWindow;
    }
}
