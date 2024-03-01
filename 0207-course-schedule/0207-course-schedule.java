class Solution {

    private boolean[][] graph;
    private boolean[] visited;
    private boolean[] onStack;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new boolean[numCourses][numCourses];
        visited = new boolean[numCourses];
        onStack = new boolean[numCourses];

        for (final int[] prerequisite : prerequisites) {
            graph[prerequisite[0]][prerequisite[1]] = true;
        }

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && hasCycle(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(final int course) {
        if (onStack[course]) {
            return true;
        }
        if (visited[course]) {
            return false;
        }

        visited[course] = true;
        onStack[course] = true;

        for (int i = 0; i < graph[course].length; i++) {
            if (graph[course][i] && hasCycle(i)) {
                return true;
            }
        }
        onStack[course] = false;
        return false;
    }
}
