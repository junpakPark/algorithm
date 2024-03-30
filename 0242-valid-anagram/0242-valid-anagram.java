class Solution {
    public boolean isAnagram(String s, String t) {
        return sort(s).equals(sort(t));
    }

    private String sort(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);

        return new String(chars);
    }
}
