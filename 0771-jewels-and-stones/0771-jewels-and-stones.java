class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> jewel = new HashMap<>();
        for (char c : jewels.toCharArray()) {
            jewel.put(c, 0);
        }
        for (char c : stones.toCharArray()) {
            jewel.computeIfPresent(c, (k, v) -> v + 1);
        }
        return jewel.values().stream()
                .mapToInt(i -> i)
                .sum();
    }
}