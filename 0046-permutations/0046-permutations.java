class Solution {

    private final List<List<Integer>> results = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> elements = Arrays.stream(nums).boxed().collect(Collectors.toList());

        dfs(new ArrayList<>(), elements);

        return results;
    }

    private void dfs(List<Integer> prevElements, List<Integer> elements) {
        if (elements.isEmpty()) {
            results.add(new ArrayList<>(prevElements));
        }

        for (final Integer element : elements) {
            List<Integer> nextElements = new ArrayList<>(elements);
            nextElements.remove(element);

            prevElements.add(element);

            dfs(prevElements, nextElements);
            prevElements.remove(element);
        }
    }
}