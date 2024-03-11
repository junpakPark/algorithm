import java.util.Map.Entry;

class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> chars = new HashMap<>();
        for (char character : s.toCharArray()) {
            chars.put(character, chars.getOrDefault(character, 0) + 1);
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (char c : order.toCharArray()) {
            if (chars.containsKey(c)) {
                String repeat = String.valueOf(c).repeat(chars.get(c));
                stringBuilder.append(repeat);
                chars.remove(c);
            }
        }
        
        for (final Entry<Character, Integer> entry : chars.entrySet()) {
            String repeat = String.valueOf(entry.getKey()).repeat(entry.getValue());
            stringBuilder.append(repeat);
        }
        
        return stringBuilder.toString();
    }
}
