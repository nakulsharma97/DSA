/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leave1 = new LinkedList<>() ;
        List<Integer> leave2 = new LinkedList<>() ;
        height(root1, leave1) ;
        height(root2, leave2) ;
        return leave1.equals(leave2)  ;
    }
    public void height(TreeNode l , List<Integer> leave){
     if( l == null) return  ;
     if(l.left ==  null && l.right == null ){
     leave.add(l.val) ;
     return ;
     }  
     height(l.left , leave) ;
     height(l.right , leave) ;
    }
}