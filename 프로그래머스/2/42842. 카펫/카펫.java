class Solution {
    public int[] solution(int brown, int yellow) {
        final int size = brown + yellow;
        
        for (int height = 3; height <= size / 3; height++) {
            if(size % height != 0) {
                continue;
            }
            final int width = size / height;
            if((width - 2) * (height - 2) == yellow) {
                return new int[]{width, height};
            }
        }
        
        return new int[0];
    }
}