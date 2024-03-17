import java.util.*;

class Solution {
    
    public int[] solution(String[] operations) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String operation : operations) {
            String[] word = operation.split(" ");
            if("I".equals(word[0])) {
                minHeap.add(Integer.parseInt(word[1]));
                maxHeap.add(Integer.parseInt(word[1]));
                continue;
            }
            if("D".equals(word[0])) {
                if("1".equals(word[1])) {
                    minHeap.remove(maxHeap.poll());
                    continue;
                }
                if("-1".equals(word[1])) {
                    maxHeap.remove(minHeap.poll());
                }
            }
        }
        
        Integer maxValue = maxHeap.poll();
        Integer minValue = minHeap.poll();
        
        return new int[] {
            (maxValue == null) ? 0 : maxValue,
            (minValue == null) ? 0 : minValue
        };
    }
}