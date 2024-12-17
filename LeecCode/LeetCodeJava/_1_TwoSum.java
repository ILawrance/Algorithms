package ProblemsLeetCode;
import java.util.HashMap;
public class _1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> setNums = new HashMap<Integer, Integer>(nums.length, 1);
        for (int i = 0; i < nums.length; i++) {
            setNums.put(nums[i], i);
        }
        int predictSolution;
        for (int i = 0; i < nums.length; i++) {
            predictSolution = target - nums[i];
            if (setNums.containsKey(predictSolution) && setNums.get(predictSolution) != i) {
                return new int[]{i, setNums.get(predictSolution)};
            }
        }
        return new int[]{};
    }
}