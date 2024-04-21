class Solution {
    private int[] parent;
    private int[] rank;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            union(u, v);
        }

        return find(source) == find(destination);
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return;
        }
        if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
            return;
        }
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
            return;
        }
        parent[rootY] = rootX;
        rank[rootX] += 1;
    }
}
