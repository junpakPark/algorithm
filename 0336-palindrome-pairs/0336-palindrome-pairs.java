class Solution {

    public List<List<Integer>> palindromePairs(String[] words) {
        Trie trie = new Trie();
        List<List<Integer>> results = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            trie.insert(i, words[i]);
        }
        for (int i = 0; i < words.length; i++) {
            List<List<Integer>> search = trie.search(i, words[i]);
            results.addAll(search);
        }
        return results;
    }

    private static class Trie {
        private final TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        private boolean isPalindrome(String word, int start, int end) {
            while (start < end) {
                if (word.charAt(start++) != word.charAt(end--)) {
                    return false;
                }
            }
            return true;
        }

        public void insert(int index, String word) {
            TrieNode current = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                if (isPalindrome(word, 0, i)) {
                    current.palindromeWordIds.add(index);
                }

                if (current.children[c - 'a'] == null) {
                    current.children[c - 'a'] = new TrieNode();
                }

                current = current.children[c - 'a'];
            }
            current.wordId = index;
        }

        public List<List<Integer>> search(int index, String word) {
            TrieNode current = root;
            List<List<Integer>> result = new ArrayList<>();

            for (int i = 0; i < word.length(); i++) {
                if (current.wordId >= 0 && isPalindrome(word, i, word.length() - 1)) {
                    result.add(Arrays.asList(index, current.wordId));
                }
                if (current.children[word.charAt(i) - 'a'] == null) {
                    return result;
                }
                current = current.children[word.charAt(i) - 'a'];
            }
            if (current.wordId >= 0 && current.wordId != index) {
                result.add(Arrays.asList(index, current.wordId));
            }
            for (int palindromeWordId : current.palindromeWordIds) {
                result.add(Arrays.asList(index, palindromeWordId));
            }
            return result;
        }

        private static class TrieNode {
            private int wordId;
            private final TrieNode[] children;
            private final List<Integer> palindromeWordIds;

            public TrieNode() {
                wordId = -1;
                children = new TrieNode[26];
                palindromeWordIds = new ArrayList<>();
            }
        }
    }

}
