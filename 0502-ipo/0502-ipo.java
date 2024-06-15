class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capitals) {
        Queue<Project> minCapitalHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.capital));
        Queue<Project> maxProfitHeap = new PriorityQueue<>((a, b) -> b.profit - a.profit);

        for (int i = 0; i < capitals.length; ++i) {
            minCapitalHeap.offer(new Project(profits[i], capitals[i]));
        }

        int availableCapital = w;

        for (int i = 0; i < k; ++i) {
            while (!minCapitalHeap.isEmpty() && minCapitalHeap.peek().capital <= availableCapital) {
                maxProfitHeap.offer(minCapitalHeap.poll());
            }

            if (maxProfitHeap.isEmpty()) {
                break;
            }

            availableCapital += maxProfitHeap.poll().profit;
        }

        return availableCapital;
    }

    private static class Project {
        public int profit;
        public int capital;

        public Project(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }
}