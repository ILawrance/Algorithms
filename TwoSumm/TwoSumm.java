package TwoSumm;
public class TwoSumm {
    public static void main(String[] args) {
    }
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length-1; i++) {
            for ( int j = i+1; j<nums.length; j++) {
                if(nums[i] + nums[j]==target) {
                    int[] ans = {i,j};
                    return ans;
                }
            }
        }
        return nums;
    }
}
