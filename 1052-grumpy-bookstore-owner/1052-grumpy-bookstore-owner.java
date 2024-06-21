class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int satisfiedCustomers = 0;
        int maxAdditionalCustomers = 0;
        int currentAdditionalCustomers = 0;

        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                satisfiedCustomers += customers[i];
            }
        }

        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                currentAdditionalCustomers += customers[i];
            }
        }
        maxAdditionalCustomers = currentAdditionalCustomers;

        for (int i = minutes; i < n; i++) {
            if (grumpy[i] == 1) {
                currentAdditionalCustomers += customers[i];
            }
            if (grumpy[i - minutes] == 1) {
                currentAdditionalCustomers -= customers[i - minutes];
            }
            maxAdditionalCustomers = Math.max(maxAdditionalCustomers, currentAdditionalCustomers);
        }

        return satisfiedCustomers + maxAdditionalCustomers;
    }
}