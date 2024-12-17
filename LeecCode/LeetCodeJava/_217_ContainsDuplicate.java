package ProblemsLeetCode;
import java.util.HashMap;

public class _217_ContainsDuplicate {
    public static void main(String[] args) {

    }
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i: nums) {
            if (map.get(i) == null) map.put(i,1);
            else return true;
        }
        return false;
    }
}
