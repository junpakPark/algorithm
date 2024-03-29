import java.math.BigDecimal;

class Solution {
    public String largestNumber(int[] nums) {
        int i = 1;

        while (i < nums.length) {
            int j = i;
            while (j > 0 && toSwap(nums[j - 1], nums[j])) {
                int tmp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = tmp;
                j--;
            }
            i++;
        }

        if (nums[0] == 0) {
            return "0";
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int num : nums) {
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }


    private boolean toSwap(int left, int right) {
        BigDecimal leftRight = new BigDecimal(String.valueOf(left) + right);
        BigDecimal rightLeft = new BigDecimal(String.valueOf(right) + left);
        return leftRight.compareTo(rightLeft) < 0;
    }

}