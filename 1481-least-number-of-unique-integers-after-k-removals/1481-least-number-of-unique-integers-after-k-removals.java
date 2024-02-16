class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> frequencyMap.get(n1) - frequencyMap.get(n2));
        heap.addAll(frequencyMap.keySet());
        
        while (k > 0 && !heap.isEmpty()) {
            int current = heap.poll(); 
            int freq = frequencyMap.get(current);
            if (k - freq < 0) {
                break;
            }
            k -= freq;
            frequencyMap.remove(current);
            
        }
        
        return frequencyMap.size();
    }
}