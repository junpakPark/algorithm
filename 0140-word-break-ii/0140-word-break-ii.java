class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
    Set<String> wordSet = new HashSet<>(wordDict);
    Map<String, List<String>> memo = new HashMap<>();
    return wordBreakHelper(s, wordSet, memo);
  }

  private List<String> wordBreakHelper(String s, Set<String> wordSet, Map<String, List<String>> memo) {
    if (memo.containsKey(s)) {
      return memo.get(s);
    }

    List<String> result = new ArrayList<>();

    
    for (int i = 1; i < s.length(); i++) {
      String prefix = s.substring(0, i);
      String suffix = s.substring(i);
      if (wordSet.contains(prefix)) {
        List<String> suffixBreaks = wordBreakHelper(suffix, wordSet, memo);
        for (String suffixBreak : suffixBreaks) {
          result.add(prefix + " " + suffixBreak);
        }
      }
    }

    if (wordSet.contains(s)) {
      result.add(s);
    }

    memo.put(s, result);
    return result;
  }
}