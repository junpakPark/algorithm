class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> counts = new HashMap<>();

        String[] words = paragraph.replaceAll("\\W+", " ")
                .toLowerCase()
                .split(" ");

        for (String word : words) {
            if (ban.contains(word)) {
                continue;
            }
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }

        return Collections.max(counts.entrySet(), Map.Entry.comparingByValue())
                .getKey();
    }
}