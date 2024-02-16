class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        if(arr == null || arr.length == 0 || k > arr.length ) {
            return 0;
        }
        
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(frequencyMap.values());
        
        while (k > 0) {
            k -= heap.poll();            
        }
        
        if(k < 0) {
            return heap.size() + 1;
        }
        return heap.size();
    }
}