class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();
        
        for (int num : nums) {
            if (num > 0) {
                positives.add(num);
                continue;
            } 
            negatives.add(num);
        }
        
        int[] result = new int[nums.length];
        int index = 0;
        
        for (int i = 0; i < positives.size(); i++) {
            result[index++] = positives.get(i);
            result[index++] = negatives.get(i);
        }
        
        return result;
    }
}