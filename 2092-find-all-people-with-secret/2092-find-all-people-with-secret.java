class Solution {

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        UnionFind unionFind = new UnionFind(n);
        unionFind.union(0, firstPerson);

        Map<Integer, List<int[]>> meetingsByTime = new TreeMap<>();
        for (int[] meeting : meetings) {
            meetingsByTime.computeIfAbsent(meeting[2], k -> new ArrayList<>()).add(meeting);
        }

        for (List<int[]> timeMeetings : meetingsByTime.values()) {
            Set<Integer> intermediateSeen = new HashSet<>();
            for (int[] meeting : timeMeetings) {
                unionFind.union(meeting[0], meeting[1]);
                intermediateSeen.add(meeting[0]);
                intermediateSeen.add(meeting[1]);
            }

            for (int person : intermediateSeen) {
                int root = unionFind.find(person);
                if (root != 0) {
                    unionFind.root[person] = person;
                }
            }
        }

        List<Integer> peopleWithSecret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (unionFind.find(i) == 0) {
                peopleWithSecret.add(i);
            }
        }
        return peopleWithSecret;
    }

    private static class UnionFind {
        private final int[] root;

        public UnionFind(int n) {
            root = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
            }
        }

        public int find(int x) {
            if (x == root[x]) {
                return x;
            }
            root[x] = find(root[x]);
            return root[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rootX == 0) {
                    root[rootY] = rootX;
                    return;
                }
                root[rootX] = rootY;
            }
        }
    }
}