import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> uniqueNums = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet());

        int sumOfUniqueNums = uniqueNums.stream().mapToInt(Integer::intValue).sum();
        int sumOfNums = Arrays.stream(nums).sum();
        int sumOfRange = IntStream.rangeClosed(1, nums.length).sum();

        int duplicateNumber = sumOfNums - sumOfUniqueNums;
        int missingNumber = sumOfRange - sumOfUniqueNums;

        return new int[]{duplicateNumber, missingNumber};
    }
}
