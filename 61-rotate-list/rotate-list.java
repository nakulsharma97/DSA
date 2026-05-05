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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return head;
        ListNode node = head;
        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        int pos = k % len;
        if (pos == 0)
            return head;
        for (int i = 0; i < len - pos - 1; i++) {
            node = node.next;
        }
        ListNode newh = node.next;
        node.next = null;
        tail.next = head;
        return newh;

    }
}