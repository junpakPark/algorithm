class Solution {
    public int trap(int[] height) {
        int start = 0;
        int end = height.length - 1;

        int volume = 0;
        int startMax = height[start];
        int endMax = height[end];

        while (start < end) {
            startMax = Math.max(height[start], startMax);
            endMax = Math.max(height[end], endMax);

            if (startMax <= endMax) {
                volume += startMax - height[start];
                start++;
                continue;
            }
            volume += endMax - height[end];
            end--;
        }

        return volume;
    }
}
