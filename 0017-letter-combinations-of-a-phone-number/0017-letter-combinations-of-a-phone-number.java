class Solution {

    private final List<String> result = new ArrayList<>();
    private final Map<Character, List<Character>> dic = new HashMap<>();
    
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return result;
        }

        dic.put('0', Collections.emptyList());
        dic.put('1', Collections.emptyList());
        dic.put('2', List.of('a', 'b', 'c'));
        dic.put('3', List.of('d', 'e', 'f'));
        dic.put('4', List.of('g', 'h', 'i'));
        dic.put('5', List.of('j', 'k', 'l'));
        dic.put('6', List.of('m', 'n', 'o'));
        dic.put('7', List.of('p', 'q', 'r', 's'));
        dic.put('8', List.of('t', 'u', 'v'));
        dic.put('9', List.of('w', 'x', 'y', 'z'));

        dfs(digits, 0, new StringBuilder());
        return result;
    }

    private void dfs(
            String digits,
            int index,
            StringBuilder path
    ) {
        if (path.length() == digits.length()) {
            result.add(path.toString());
            return;
        }

        for (final Character c : dic.get(digits.charAt(index))) {
            dfs(digits, index + 1, new StringBuilder(path).append(c));
        }
    }
}
