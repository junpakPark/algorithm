class Solution {
    
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left != right) {
            if (numbers[left] + numbers[right] < target) {
                left += 1;
                continue;
            }
            if (numbers[left] + numbers[right] > target) {
                right -= 1;
                continue;
            }
            return new int[]{left + 1, right + 1};
        }
        return null;
    }

}
