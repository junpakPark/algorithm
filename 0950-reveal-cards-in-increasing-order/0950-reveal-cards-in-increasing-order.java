public class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (!queue.isEmpty()) {
                queue.add(queue.poll());
            }
            queue.add(deck[i]);
        }

        int i = n - 1;
        int[] answer = new int[n];
        while (!queue.isEmpty()) {
            answer[i] = queue.poll();
            i--;
        }
        return answer;
    }
}