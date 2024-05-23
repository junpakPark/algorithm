class Solution {
    private int[] nums;
    private final int[] count = new int[1010];
    private int answer = -1;
    private int k;

    public int beautifulSubsets(int[] nums, int k) {
        this.k = k;
        this.nums = nums;
        dfs(0);

        return answer;
    }

    private void dfs(int index) {
        if (index >= nums.length) {
            answer++;
            return;
        }

        dfs(index + 1);

        if (canInclude(index)) {
            count[nums[index]]++;
            dfs(index + 1);
            count[nums[index]]--;
        }
    }

    private boolean canInclude(int index) {
        return (nums[index] + k >= count.length || count[nums[index] + k] == 0) &&
                (nums[index] - k < 0 || count[nums[index] - k] == 0);
    }

}
