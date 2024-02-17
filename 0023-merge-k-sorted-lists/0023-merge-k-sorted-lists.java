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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((Comparator.comparingInt(o -> o.val)));

        ListNode root = new ListNode(0);
        ListNode tail = root;

        for (ListNode node : lists) {
            if (node != null) {
                priorityQueue.add(node);
            }           
        }
         while (!priorityQueue.isEmpty()) {
                tail.next = priorityQueue.poll();
                tail = tail.next;

                if (tail.next != null) {
                    priorityQueue.add(tail.next);
                }
            }
        return root.next;
    }
}