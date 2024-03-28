/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode parent = dummy;

        while (head != null) {
            while (parent.next != null && parent.next.val < head.val) {
                parent = parent.next;
            }

            ListNode nextParent = parent.next;
            ListNode nextHead = head.next;
            parent.next = head;
            head.next = nextParent;
            head = nextHead;

            if (head != null && parent.val > head.val) {
                parent = dummy;
            }

        }
        return dummy.next;
    }
}