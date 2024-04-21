class Solution {

    private List<List<Integer>> graph;
    private boolean[] visited;
    private int destination;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        this.visited = new boolean[n];
        this.destination = destination;
        this.graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        return bfs(source);
    }

    private boolean bfs(final int source) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            if (currentNode == destination) {
                return true;
            }

            for (int adjacentNode : graph.get(currentNode)) {
                if (!visited[adjacentNode]) {
                    visited[adjacentNode] = true;
                    queue.add(adjacentNode);
                }
            }
        }

        return false;
    }
}
