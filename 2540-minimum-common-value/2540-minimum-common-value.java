class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (final int i : nums1) {
            set1.add(i);
        }
        Set<Integer> set2 = new HashSet<>();
        for (final int i : nums2) {
            set2.add(i);
        }

        set1.retainAll(set2);

        if (set1.size() <= 0) {
            return -1;
        }
        return Collections.min(set1);
    }
}
