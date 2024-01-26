class Solution {

    private int start = 0;
    private int end = 0;

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        int length = s.length();

        if (length < 2) {
            return s;
        }

        for (int i = 0; i < length - 1; i++) {
            expandAroundCenter(s, i, i + 1);
            expandAroundCenter(s, i, i + 2);
        }
        return s.substring(start, start + end);
    }

    private void expandAroundCenter(String s, int left, int right) {
        while (isInRange(s, left, right) && isPalindrome(s, left, right)) {
            left--;
            right++;
        }
        
        if (end < right - left - 1) {
            start = left + 1;
            end = right - left - 1;
        }
    }

    private boolean isInRange(String s, int left, int right) {
        return left >= 0 && right < s.length();
    }

    private boolean isPalindrome(String s, int left, int right) {
        return s.charAt(left) == s.charAt(right);
    }
}
