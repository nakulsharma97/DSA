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
    public int pairSum(ListNode head) {
        ListNode slow = head ;
        ListNode fast = head ;
        while(fast != null && fast.next != null){
            slow = slow.next ;
            fast = fast.next.next ;
        }
        ListNode nextnode = null ;
        ListNode prev = null ;
        while(slow != null){
            nextnode = slow.next ;
            slow.next =  prev ;
            prev = slow ;
            slow =nextnode ;

        } 
        int res = 0 ;
        while(prev != null){
            res = Math.max(res , head.val + prev.val) ;
            head = head.next ;
        prev = prev.next ;

        }
        return res ;
    }
}