public class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        int n = tickets.length;

        while (tickets[k] > 0) {
            for (int i = 0; i < n; i++) {
                if (tickets[i] > 0) {
                    tickets[i]--;
                    time++;
                }
                if (tickets[k] == 0) {
                    break;
                }
            }
        }

        return time;
    }
}