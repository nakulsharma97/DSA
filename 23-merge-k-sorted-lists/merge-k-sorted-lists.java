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
        //  int n = lists.length 
        PriorityQueue<ListNode> p = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if(node != null){
            p.offer(node);
            }
        }
        if (p.isEmpty()) {
            return null;
        }

        ListNode head = p.poll();
        if (head.next != null) {
            p.offer(head.next);
        }
        ListNode tail = head ;
        while (!p.isEmpty()) {
            ListNode curr = p.poll() ;
            tail.next = curr ;
            tail = tail.next ;
            if(curr.next != null){
                p.offer(curr.next) ;
            }
        }
        return head;

    }
}