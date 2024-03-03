class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode current = head;

        while (current != null) {
            nodes.add(current);
            current = current.next;
        }

        int targetIndex = nodes.size() - n;

        if (targetIndex == 0) {
            return head.next;
        }

        ListNode prev = nodes.get(targetIndex - 1);
        prev.next = prev.next.next;

        return head;
    }
}