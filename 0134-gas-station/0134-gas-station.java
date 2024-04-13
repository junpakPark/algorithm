public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        for (int i : gas) {
            gasSum += i;
        }
        int costSum = 0;
        for (int i : cost) {
            costSum += i;
        }
        if (gasSum < costSum) {
            return -1;
        }

        int start = 0, fuel = 0;
        for (int i = 0; i < gas.length; i++) {
            if (fuel + gas[i] - cost[i] < 0) {
                start = i + 1;
                fuel = 0;
                continue;
            }
            fuel += gas[i] - cost[i];
        }
        return start;
    }
}