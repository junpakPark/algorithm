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
    public ListNode doubleIt(ListNode head) {
        if (head == null) {
            return null;
        }
        
        
        ListNode reversed = reverseList(head);
        ListNode current = reversed;
        int carry = 0;
        while (current != null) {
            int doubledValue = current.val * 2 + carry;
            current.val = doubledValue % 10;
            carry = doubledValue / 10;
            current = current.next;
        }
        
        if (carry > 0) {
            ListNode last = new ListNode(carry);
            getLastNode(reversed).next = last;
        }
        
        return reverseList(reversed);   
    }
    
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    
    private ListNode getLastNode(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            current = current.next;
        }
        return current;
    }
}