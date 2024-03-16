class Solution {
    public int findKthLargest(int[] nums, int k) {
        BinaryHeap heap = new BinaryHeap();
        for (final int num : nums) {
            heap.insert(num);
        }

        for (int i = 0; i < k - 1; i++) {
            heap.extract();
        }

        return heap.extract();
    }

    private static class BinaryHeap {

        private final List<Integer> elements;

        private BinaryHeap() {
            this.elements = new ArrayList<>();
            elements.add(null);
        }

        public void insert(final int element) {
            elements.add(element);
            percolateUp();
        }

        public int extract() {
            int extract = elements.get(1);
            int lastIndex = elements.size() - 1;

            elements.set(1, elements.get(lastIndex));
            elements.remove(lastIndex);
            maxHeapify(1);

            return extract;
        }

        private void swap(final int i, final int j) {
            int temp = elements.get(i);
            elements.set(i, elements.get(j));
            elements.set(j, temp);
        }

        private void percolateUp() {
            int lastIndex = elements.size() - 1;
            int parentIndex = lastIndex / 2;

            while (parentIndex > 0) {
                if (elements.get(lastIndex) > elements.get(parentIndex)) {
                    swap(lastIndex, parentIndex);
                }
                lastIndex = parentIndex;
                parentIndex = lastIndex / 2;
            }
        }

        private void maxHeapify(final int largestIndex) {
            int largest = largestIndex;
            int left = largestIndex * 2;
            int right = largestIndex * 2 + 1;

            if (left <= elements.size() - 1 && elements.get(left) > elements.get(largest)) {
                largest = left;
            }
            if (right <= elements.size() - 1 && elements.get(right) > elements.get(largest)) {
                largest = right;
            }
            if (largest != largestIndex) {
                swap(largest, largestIndex);
                maxHeapify(largest);
            }
        }
    }
}
