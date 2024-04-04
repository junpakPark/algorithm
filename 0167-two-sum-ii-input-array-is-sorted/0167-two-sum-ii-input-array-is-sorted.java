class Solution {

    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int left = i + 1, right = numbers.length - 1;
            int expected = target - numbers[i];
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (numbers[mid] < expected) {
                    left = mid + 1;
                    continue;
                }
                if (numbers[mid] > expected) {
                    right = mid - 1;
                    continue;
                }
                return new int[]{i + 1, mid + 1};
            }
        }
        return null;
    }

}
