class Solution {

    private int[][] graph;
    private boolean[] visited;
    private boolean[] onStack;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new int[numCourses][numCourses];
        visited = new boolean[numCourses];
        onStack = new boolean[numCourses];

        for (final int[] prerequisite : prerequisites) {
            graph[prerequisite[0]][prerequisite[1]] = 1;
        }

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && hasCycle(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(final int i) {
        visited[i] = true;
        onStack[i] = true;

        for (int j = 0; j < graph[i].length; j++) {

            if (graph[i][j] == 1) {
                if ((!visited[j] && hasCycle(j)) || onStack[j]) {
                    return true;
                }
            }
        }
        onStack[i] = false;
        return false;
    }
}
