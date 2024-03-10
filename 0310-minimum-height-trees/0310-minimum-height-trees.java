class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return List.of(0);
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (final int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>())
                    .add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>())
                    .add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        while (n > 2) {
            n -= leaves.size();

            List<Integer> newLeaves = new ArrayList<>();
            for (final Integer leaf : leaves) {
                Integer neighbor = graph.get(leaf).get(0);
                graph.get(neighbor).remove(leaf);

                if (graph.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
