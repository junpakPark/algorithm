class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        Set<Integer> intersections = new HashSet<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                j++;
                continue;
            }
            if (nums1[i] < nums2[j]) {
                i++;
                continue;
            }
            intersections.add(nums1[i]);
            i++;
            j++;
        }

        int[] result = new int[intersections.size()];
        i = 0;
        for (int num : intersections) {
            result[i++] = num;
        }

        return result;
    }
}
