class Solution {
    public int majorityElement(int[] nums) {
        return divideAndConquer(0, nums.length - 1, nums);
    }

    private int divideAndConquer(int left, int right, int[] nums) {
        if (left == right) {
            return nums[left];
        }

        int mid = left + (right - left) / 2;
        int a = divideAndConquer(left, mid, nums);
        int b = divideAndConquer(mid + 1, right, nums);

        int count = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == a) {
                count++;
            }
        }
        return count > (right - left + 1) / 2 ? a : b;
    }
}