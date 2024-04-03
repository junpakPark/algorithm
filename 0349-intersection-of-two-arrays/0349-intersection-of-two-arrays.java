class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums2);

        Set<Integer> intersections = new HashSet<>();
        for (int num : nums1) {
            if (Arrays.binarySearch(nums2, num) >= 0) {
                intersections.add(num);
            }
        }

        int[] result = new int[intersections.size()];
        int i = 0;
        for (int num : intersections) {
            result[i++] = num;
        }

        return result;
    }
}