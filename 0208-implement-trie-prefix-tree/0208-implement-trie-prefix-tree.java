class Trie {

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            TrieNode child = current.children[c - 'a'];

            if (child == null) {
                current.children[c - 'a'] = new TrieNode();
            }

            current = current.children[c - 'a'];
        }
        current.word = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            TrieNode child = current.children[c - 'a'];
            if (child == null) {
                return false;
            }
            current = child;
        }
        return current.word;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            TrieNode child = current.children[c - 'a'];
            if (child == null) {
                return false;
            }
            current = child;
        }
        return true;
    }

    private static class TrieNode {
        private boolean word;
        private final TrieNode[] children;

        public TrieNode() {
            word = false;
            children = new TrieNode[26];
        }
    }
}


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */