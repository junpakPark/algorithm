class Solution {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr1) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> resultList = new ArrayList<>();
        for (int num : arr2) {
            int count = frequencyMap.get(num);
            for (int i = 0; i < count; i++) {
                resultList.add(num);
            }
            frequencyMap.remove(num);
        }

        List<Integer> remaining = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                remaining.add(num);
            }
        }
        Collections.sort(remaining);
        resultList.addAll(remaining);

        int[] resultArray = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArray[i] = resultList.get(i);
        }

        return resultArray;
    }
}