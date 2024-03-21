import java.util.*;

class Solution {
     public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        Deque<Integer> deliverStack = new ArrayDeque<>();
        Deque<Integer> pickupStack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (deliveries[i] != 0) {
                deliverStack.push(i);
            }
            if (pickups[i] != 0) {
                pickupStack.push(i);
            }
        }

        long answer = 0;
        while (!(deliverStack.isEmpty() && pickupStack.isEmpty())) {
            int dDistance = deliverStack.isEmpty() ? -1 : deliverStack.peek();
            int pDistance = pickupStack.isEmpty() ? -1 : pickupStack.peek();
            answer += (Math.max(dDistance, pDistance) + 1) * 2L;

            process(deliveries, deliverStack, cap);
            process(pickups, pickupStack, cap);
        }
        return answer;
    }

    private void process(int[] route, Deque<Integer> stack, int cap) {
        while (!stack.isEmpty() && cap > 0) {
            int index = stack.pop();

            if (route[index] <= cap) {
                cap -= route[index];
                route[index] = 0;
                continue;
            }

            route[index] -= cap;
            stack.push(index);
            break;
        }
    }
}