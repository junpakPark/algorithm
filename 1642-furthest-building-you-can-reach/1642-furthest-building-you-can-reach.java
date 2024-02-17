import java.util.PriorityQueue;

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> ladderAllocations = new PriorityQueue<>();

        for (int i = 0; i < heights.length - 1; i++) {
            int difference = heights[i + 1] - heights[i];

            if (difference > 0) {
                ladderAllocations.add(difference);
                
                if (ladderAllocations.size() > ladders) {
                    bricks -= ladderAllocations.poll();
                }
                if (bricks < 0) {
                    return i;
                }
            }
        }
        
        return heights.length - 1;
    }
}