class Solution {
    public boolean isIsomorphic(String s, String t) {
        return convert(s).equals(convert(t));
    }

    private String convert(String value) {
        StringBuilder stringBuilder = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : value.toCharArray()) {
            stringBuilder.append(map.computeIfAbsent(c, k -> map.keySet().size() + 1));
        }
        return stringBuilder.toString();
    }
}
