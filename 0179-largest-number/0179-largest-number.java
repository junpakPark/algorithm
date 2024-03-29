public class Solution {
    public String largestNumber(int[] nums) {
        String[] numsStrings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsStrings[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numsStrings,
                (s1, s2) -> (s2 + s1).compareTo(s1 + s2)
        );

        if (numsStrings[0].equals("0")) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        for (String numString : numsStrings) {
            result.append(numString);
        }
        return result.toString();
    }
}