import java.util.PriorityQueue;

public class Solution {

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int s : scoville) {
            priorityQueue.add(s);
        }

        int answer = 0;

        while (priorityQueue.size() > 1 && priorityQueue.peek() < K) {
            int firstMin = priorityQueue.poll();
            int secondMin = priorityQueue.poll();

            priorityQueue.add(firstMin + (secondMin * 2));
            answer++;
        }

        if (priorityQueue.peek() < K) {
            return -1;
        }
        return answer;
    }
}