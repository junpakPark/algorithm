

class Solution {
    private static final int MAX_VALUE = 100010;
    private static final List<Integer>[] primeFactors = new List[MAX_VALUE];

    static {
        Arrays.setAll(primeFactors, k -> new ArrayList<>());
        for (int x = 2; x < MAX_VALUE; ++x) {
            if (primeFactors[x].isEmpty()) {
                for (int j = x; j < MAX_VALUE; j += x) {
                    primeFactors[j].add(x);
                }
            }
        }
    }

    public boolean canTraverseAllPairs(int[] nums) {
        int maxNum = Arrays.stream(nums).max().getAsInt();
        UnionFind unionFind = new UnionFind(nums.length + maxNum + 1);
        for (int i = 0; i < nums.length; ++i) {
            for (int prime : primeFactors[nums[i]]) {
                unionFind.union(i, prime + nums.length);
            }
        }
        Set<Integer> rootSet = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            rootSet.add(unionFind.find(i));
        }
        return rootSet.size() == 1;
    }

    private static class UnionFind {
        private final int[] parent;
        private final int[] size;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; ++i) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);

            if (rootA == rootB) {
                return;
            }

            if (size[rootA] > size[rootB]) {
                parent[rootB] = rootA;
                size[rootA] += size[rootB];
                return;
            }

            parent[rootA] = rootB;
            size[rootB] += size[rootA];
        }
    }
}
