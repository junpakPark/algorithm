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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode startNode = list1;
        ListNode endNode = list1;
        
        for(int i = 0; i < b; i++) {
            if(i < a - 1) {
                startNode = startNode.next;
            }
            endNode = endNode.next;
        }
        
        ListNode last = list2;
        while(last.next != null) {
            last = last.next;
        }
        
        startNode.next = list2;
        last.next = endNode.next;
        
        return list1;
    }
}