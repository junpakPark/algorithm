class Solution {

    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int expected = target - numbers[i];
            int index = Arrays.binarySearch(numbers, i + 1, numbers.length, expected);
            if (index >= 0) {
                return new int[]{i + 1, index + 1};
            }
        }
        return null;
    }

}
