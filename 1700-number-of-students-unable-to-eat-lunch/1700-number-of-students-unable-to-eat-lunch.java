public class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] count = new int[2];
        for (int student : students) {
            count[student]++;
        }

        int i = 0;
        while (i < sandwiches.length && count[sandwiches[i]] > 0) {
            count[sandwiches[i]]--;
            i++;
        }

        return sandwiches.length - i;
    }
}
