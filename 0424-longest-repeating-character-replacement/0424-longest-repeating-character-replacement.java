class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        Map<Character, Integer> counts = new HashMap<>();
        for (int right = 1; right <= s.length(); right++) {
            char rightChar = s.charAt(right - 1);
            counts.put(rightChar, counts.getOrDefault(rightChar, 0) + 1);

            int maxCharCount = Collections.max(counts.values());

            if (right - left - maxCharCount > k) {
                char leftChar = s.charAt(left);
                counts.put(leftChar, counts.getOrDefault(leftChar, 0) - 1);
                left++;
            }
        }
        return s.length() - left;
    }
}