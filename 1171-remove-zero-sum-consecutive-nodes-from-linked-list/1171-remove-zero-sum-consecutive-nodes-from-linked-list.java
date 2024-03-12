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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode zero = new ListNode(0);
        zero.next = head;
        
        ListNode current = zero;
        
        while(current != null) {
            int sum = 0;
            boolean found = false;
            ListNode temp = current.next;
            
            while(temp != null) {
                sum += temp.val;
                if (sum == 0) {
                    current.next = temp.next;
                    found = true;
                    break;
                }
                temp = temp.next;
            }
            
            if(!found) {
                current = current.next;
            }
        }
        
        return zero.next;
    }
}