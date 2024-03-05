class Solution {
    public int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right && s.charAt(left) == s.charAt(right)) {
            char similar = s.charAt(left);

            while (left <= right && s.charAt(left) == similar) {
                left++;
            }

            while (left <= right && s.charAt(right) == similar) {
                right--;
            }

        }

        return right - left + 1;
    }
}