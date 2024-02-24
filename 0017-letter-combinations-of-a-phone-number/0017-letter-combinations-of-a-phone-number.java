
class Solution {

    private final List<String> result = new ArrayList<>();
    private final Map<Character, List<Character>> dic = Map.of(
            '0', Collections.emptyList(),
            '1', Collections.emptyList(),
            '2', List.of('a', 'b', 'c'),
            '3', List.of('d', 'e', 'f'),
            '4', List.of('g', 'h', 'i'),
            '5', List.of('j', 'k', 'l'),
            '6', List.of('m', 'n', 'o'),
            '7', List.of('p', 'q', 'r', 's'),
            '8', List.of('t', 'u', 'v'),
            '9', List.of('w', 'x', 'y', 'z')
    );

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return result;
        }
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
            path.append(c);
            dfs(digits, index + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}

