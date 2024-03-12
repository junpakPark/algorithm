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
        int prefixSum = 0;
        
        Map<Integer, ListNode> map = new HashMap<>();
        map.put(prefixSum, zero);
        
        
        ListNode current = head;
        while(current != null) {
            prefixSum += current.val;
            map.put(prefixSum, current);
            current = current.next;
        }
        
        current = zero;
        prefixSum = 0;
        while(current != null) {
            prefixSum += current.val;
            current.next = map.get(prefixSum).next;
            current = current.next;
        }
        
        return zero.next;
    }
}