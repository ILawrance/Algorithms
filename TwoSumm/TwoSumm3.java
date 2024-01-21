package TwoSumm;

import java.util.HashMap;
import java.util.Map;



public class TwoSumm3 {

    public static void main(String[] args) {
        int[] ansv = twoSum(new int[]{2,3,6}, 8);
        for (int i = 0; i < 2; i++) {
            System.out.println(ansv[i]);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }

        return new int[]{}; 
    }
}
