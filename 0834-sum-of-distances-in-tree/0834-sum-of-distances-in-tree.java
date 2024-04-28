class Solution {
	public int[] sumOfDistancesInTree(int n, int[][] edges) {
		List<Set<Integer>> tree = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			tree.add(new HashSet<>());
		}
		for (int[] edge : edges) {
			tree.get(edge[0]).add(edge[1]);
			tree.get(edge[1]).add(edge[0]);
		}

		int[] res = new int[n];
		int[] count = new int[n];
		Arrays.fill(count, 1);

		dfs(tree, res, count, 0, -1);
		dfs2(tree, res, count, 0, -1);

		return res;
	}

	private void dfs(List<Set<Integer>> tree, int[] res, int[] count, int root, int pre) {
		for (int item : tree.get(root)) {
			if (item == pre) {
				continue;
			}
			dfs(tree, res, count, item, root);
			count[root] += count[item];
			res[root] += res[item] + count[item];
		}

	}

	private void dfs2(List<Set<Integer>> tree, int[] res, int[] count, int root, int pre) {
		for (int item : tree.get(root)) {
			if (item == pre) {
				continue;
			}
			res[item] = res[root] - count[item] + count.length - count[item];
			dfs2(tree, res, count, item, root);
		}
	}
}
