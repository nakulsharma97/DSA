/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root ;
        TreeNode leftt = lowestCommonAncestor(root.left, p,  q);
        TreeNode rightt = lowestCommonAncestor( root.right,  p,  q);
        if(leftt == null){
            return rightt ;
        }else if(rightt == null){
            return leftt ;
        }
        else {
            return root ;
        }
    
    }
}