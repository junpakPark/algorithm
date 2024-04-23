
public class Solution {
    private final List<List<Integer>> graph = new ArrayList<>();

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return List.of(0);
        }
        int[] degrees = new int[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
            degrees[u]++;
            degrees[v]++;
        }
        return removeLeaves(degrees);
    }


    private List<Integer> removeLeaves(int[] degrees) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] == 1) {
                queue.add(i);
            }
        }

        List<Integer> currentLevel = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            currentLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                currentLevel.add(node);
                for (int neighbor : graph.get(node)) {
                    degrees[neighbor]--;
                    if (degrees[neighbor] == 1) {
                        queue.add(neighbor);
                    }
                }
            }
        }
        return currentLevel;
    }
}
