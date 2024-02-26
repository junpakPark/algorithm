
class Solution {

    private List<List<Integer>> results;
    private LinkedList<Integer> elements;
    private int totalNumber;

    public List<List<Integer>> combine(int n, int k) {
        results = new ArrayList<>();
        elements = new LinkedList<>();
        totalNumber = n;

        dfs(1, k);

        return results;
    }

    private void dfs(int start, int k) {
        if (k == 0) {
            results.add(new ArrayList<>(elements));
            return;
        }

        for (int i = start; i <= totalNumber; i++) {
            elements.add(i);
            dfs(i + 1, k - 1);
            elements.removeLast();
        }
    }
}
