class Solution {
    public boolean isPalindrome(ListNode head) {
        Deque<Integer> deque = new ArrayDeque<>();

        ListNode node = head;
        while (node != null) {
            deque.add(node.val);
            node = node.next;
        }

        while (!deque.isEmpty() && deque.size() >1) {

            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }

        }
        return true;
    }
}