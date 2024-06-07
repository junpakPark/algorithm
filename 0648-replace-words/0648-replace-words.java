class Solution {
   public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();

        for (String root : dictionary) {
            trie.insert(root);
        }

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(trie.searchPrefix(word));
        }

        return result.toString();
    }
    
    private static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word;
    }

    private static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                node.children.putIfAbsent(c, new TrieNode());
                node = node.children.get(c);
            }
            node.word = word;
        }

        public String searchPrefix(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children.containsKey(c)) {
                    node = node.children.get(c);
                    if (node.word != null) {
                        return node.word;
                    }
                    continue;
                } 
                break;
            }
            return word;
        }
    }
}