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
    int ans = 0 ;
    public int averageOfSubtree(TreeNode root) {
        if(root == null){
            return 0 ;
        }
        int sum = getsum(root) ;
        int count = getcount(root) ;
        
        if(sum / count == root.val){
            ans++ ;
        }
        averageOfSubtree(root.left) ;
        averageOfSubtree(root.right) ;
        return ans ;
        
    }
    public int getsum(TreeNode root){
        if(root == null){
            return 0 ;
        }
        return root.val + getsum(root.left) + getsum(root.right) ;
    }
    public int getcount(TreeNode root){
        if(root == null){
            return 0 ;
        }
        return 1 + getcount(root.left) + getcount(root.right) ;
    }
}