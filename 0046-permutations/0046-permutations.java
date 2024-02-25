
class Solution {

    private final List<List<Integer>> results = new ArrayList<>();
    private int[] elements;

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return results;
        }
        elements = nums;

        dfs(new ArrayList<>(), new HashSet<>());

        return results;
    }

    private void dfs(List<Integer> curr, Set<Integer> seen) {
        if (curr.size() == elements.length) {
            results.add(new ArrayList<>(curr));
            return;
        }

        for (final int element : elements) {
            if (seen.contains(element)) {
                continue;
            }
            curr.add(element);
            seen.add(element);
            dfs(curr, seen);
            curr.remove(curr.size() - 1);
            seen.remove(element);
        }
    }
}
