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
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>() ;
        if(root == null){
            return false  ;
        }
        q.offer(root.right) ;
        q.offer(root.left) ;
        while(!q.isEmpty()){
            TreeNode node = q.poll() ;
            TreeNode node1 = q.poll() ;
            if(node == null && node1 == null){
                continue  ;
            }
            if(node == null || node1 == null ){
                return false  ;
            }
            if(node.val != node1.val){
                return false  ;
            }
            q.offer(node.left) ;
            q.offer(node1.right) ;
            q.offer(node.right) ;
            q.offer(node1.left) ;
        }
        return true  ;
    }
}