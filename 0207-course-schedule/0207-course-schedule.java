class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> finishToTakeMap = new HashMap<>();
        for (int[] pre : prerequisites) {
            finishToTakeMap.computeIfAbsent(pre[0], K -> new ArrayList<>())
                    .add(pre[1]);
        }

        List<Integer> takes = new ArrayList<>();
        List<Integer> visited = new ArrayList<>();

        for (Integer finish : finishToTakeMap.keySet()) {
            if (hasCycle(finishToTakeMap, finish, takes, visited)) {
                return false;
            }
        }

        return true;
    }

    public boolean hasCycle(
            Map<Integer, List<Integer>> finishToTakeMap,
            Integer finish,
            List<Integer> takes,
            List<Integer> visited
    ) {
        if (takes.contains(finish)) {
            return true;
        }
        if (visited.contains(finish)) {
            return false;
        }

        if (finishToTakeMap.containsKey(finish)) {
            takes.add(finish);
            for (Integer take : finishToTakeMap.get(finish)) {
                if (hasCycle(finishToTakeMap, take, takes, visited)) {
                    return true;
                }
            }
            takes.remove(finish);
            visited.add(finish);
        }

        return false;
    }
}

