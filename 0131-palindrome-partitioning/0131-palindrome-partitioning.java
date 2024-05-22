class Solution {

    private final List<List<String>> result = new ArrayList<>();
    private final List<String> currentPartition = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(s, 0);
        return result;
    }

    private void backtrack(String s, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(currentPartition));
            return;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);
            if (isPalindrome(substring)) {
                currentPartition.add(substring);
                backtrack(s, end);
                currentPartition.remove(currentPartition.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
