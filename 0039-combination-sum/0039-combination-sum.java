class Solution {

    private final List<List<Integer>> results = new ArrayList<>();
    private final Deque<Integer> path = new ArrayDeque<>();
    private int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;

        dfs(target, 0);

        return results;
    }

    private void dfs(final int target, final int index) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            results.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            dfs(target - candidates[i], i);
            path.removeLast();
        }
    }
}
