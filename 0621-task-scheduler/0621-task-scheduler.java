class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] taskCounts = new int[26];
        for (char task : tasks) {
            taskCounts[task - 'A']++;
        }
        Arrays.sort(taskCounts);
        
        int maxFrequency = taskCounts[25];
        int idleTime = (maxFrequency - 1) * n;
        
        for (int i = 24; i>=0; i--) {
            if(idleTime <= 0) {
                break;
            }
            idleTime -= Math.min(maxFrequency - 1, taskCounts[i]);
        }
        
        return tasks.length + Math.max(0, idleTime);
    }
}