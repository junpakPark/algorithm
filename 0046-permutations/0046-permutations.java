class Solution {

    private final List<List<Integer>> results = new ArrayList<>();
    private int[] elements;
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return results;
        }
        elements = nums;
        used = new boolean[nums.length];

        backtracking(new ArrayList<>());

        return results;
    }

    private void backtracking(List<Integer> previous) {
        if (previous.size() == elements.length) {
            results.add(new ArrayList<>(previous));
            return;
        }
        
        for (int i = 0; i < elements.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            previous.add(elements[i]);
            backtracking(previous);
            previous.remove(previous.size() - 1);
            used[i] = false;
        }
    }
}
