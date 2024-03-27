class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        
        List<int[]> merged = new ArrayList<>();
        for(int[] interval : intervals) {
            if(!merged.isEmpty() && interval[0] <= merged.get(merged.size() -1)[1]) {
                merged.get(merged.size() -1)[1] = Math.max(merged.get(merged.size() -1)[1], interval[1]);
                continue;
            }
            merged.add(interval);
        }
        
        return merged.toArray(new int[merged.size()][]);
    }
}