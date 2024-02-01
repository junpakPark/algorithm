import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        List<Integer> pair = new ArrayList<>();
        int result = 0;

        for (int num : nums) {
            pair.add(num);
            if (pair.size() == 2) {
                result += Collections.min(pair);
                pair.clear();
            }
        }
        return result;
    }

}
