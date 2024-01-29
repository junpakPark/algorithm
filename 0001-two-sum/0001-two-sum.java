import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numbers = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];

            if (numbers.containsKey(key)) {
                return new int[]{numbers.get(key), i};
            }

            numbers.put(nums[i], i);
        }

        return null;
    }
}