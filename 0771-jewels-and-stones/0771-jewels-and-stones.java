class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> stoneMap = new HashMap<>();

        for (char stone : stones.toCharArray()) {
            if (stoneMap.containsKey(stone)) {
                stoneMap.put(stone, stoneMap.get(stone) + 1);
                continue;
            }
            stoneMap.put(stone, 1);
        }

        int count = 0;
        for (char jewel : jewels.toCharArray()) {
            if (stoneMap.containsKey(jewel)) {
                count += stoneMap.get(jewel);
            }
        }
        return count;
    }
}
