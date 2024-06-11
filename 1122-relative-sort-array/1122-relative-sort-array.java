class Solution {
 public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> rank = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            rank.put(arr2[i], i);
        }

        return Arrays.stream(arr1)
            .boxed()
            .sorted((a, b) -> {
                if (rank.containsKey(a) && rank.containsKey(b)) {
                    return rank.get(a) - rank.get(b);
                } 
                if (rank.containsKey(a)) {
                    return -1;
                } 
                if (rank.containsKey(b)) {
                
                    return 1;
                } 
                return a - b;
            })
            .mapToInt(Integer::intValue)
            .toArray();
    }
}