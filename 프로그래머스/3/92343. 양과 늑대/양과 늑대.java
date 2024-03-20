import java.util.*;

class Solution {

    private final Map<Integer, List<Integer>> graph = new HashMap<>();
    private int maxSheep = 1;

    public int solution(int[] info, int[][] edges) {
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>())
                    .add(edge[1]);
        }

        bfs(info);

        return maxSheep;
    }

    private void bfs(int[] info) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 1, 0, graph.get(0)));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int child : current.children) {
                int newSheep = current.sheep;
                int newWolf = current.wolf;

                if (info[child] == 0) {
                    newSheep++;
                } else {
                    newWolf++;
                }

                if (newSheep <= newWolf) {
                    continue;
                }

                maxSheep = Math.max(maxSheep, newSheep);

                List<Integer> children = new ArrayList<>(current.children);
                children.remove((Integer) child);
                if (graph.get(child) != null) {
                    children.addAll(graph.get(child));
                }

                queue.offer(new Node(child, newSheep, newWolf, children));
            }
        }
    }

    private static class Node {
        private final int value;
        private final int sheep;
        private final int wolf;
        private final List<Integer> children;

        private Node(final int value, final int sheep, final int wolf, final List<Integer> children) {
            this.value = value;
            this.sheep = sheep;
            this.wolf = wolf;
            this.children = children;
        }

    }
}