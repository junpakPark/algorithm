class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode left = head;
        ListNode right = head.next;

        int i = 1;
        while (right != null) {
            right = right.next;

            if (i > n) {
                left = left.next;
            }
            i++;
        }

        if (i == n) {
            return head.next;
        }
        left.next = left.next.next;
        
        return head;
    }
}