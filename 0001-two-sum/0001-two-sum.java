import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numbers = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            numbers.put(nums[i], i);
        }

        for (int i = 0; i < nums.length - 1; i++) {
            int key = target - nums[i];

            if (numbers.containsKey(key) && i != numbers.get(key)) {
                return new int[]{i, numbers.get(key)};
            }
        }
        return null;
    }
}