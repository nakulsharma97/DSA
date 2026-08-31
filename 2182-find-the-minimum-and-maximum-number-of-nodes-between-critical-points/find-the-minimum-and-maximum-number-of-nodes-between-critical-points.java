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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode temp = head ;
        List<Integer> list = new ArrayList<>() ;
        while(temp != null){
            list.add(temp.val) ;
            temp =temp.next ;
        }
        int n = list.size()  ;
        List<Integer> critical = new ArrayList<>() ;
        for(int i = 1 ; i< n - 1 ;i++){
          if(list.get(i) > list.get(i-1) && list.get(i)  > list.get(i +1)){
            critical.add(i) ;
          }
          if(list.get(i) < list.get(i -1) && list.get(i)  <list.get(i +1)){
            critical.add(i) ;
          }
        }
        int m = critical.size() ;
        if(m < 2){
            return new int[]{-1 ,-1} ;
        }
        int max = critical.get(m-1) - critical.get(0) ;
        int min = Integer.MAX_VALUE ;
        for(int i = 1 ; i < m ;i++){
            min =Math.min(min , critical.get(i) - critical.get(i-1)) ;
        }
        return new int[]{min, max} ;
    }
}