class Solution {

    private final List<List<Integer>> results = new ArrayList<>();
    private final Deque<Integer> path = new ArrayDeque<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);

        return results;
    }

    private void dfs(int[] nums, int index) {
        results.add(new ArrayList<>(path));

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i + 1);
            path.removeLast();
        }
    }
}