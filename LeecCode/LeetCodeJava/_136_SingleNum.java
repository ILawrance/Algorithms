package ProblemsLeetCode;

public class _136_SingleNum {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{5, 2, 1, 5, 1}));
    }

    public static int singleNumber(int[] nums) {
        if (nums.length == 1) return nums[0];
        int summ = 0;
        for (int num : nums) {
            summ ^= num;
        }
        return summ;
    }
}