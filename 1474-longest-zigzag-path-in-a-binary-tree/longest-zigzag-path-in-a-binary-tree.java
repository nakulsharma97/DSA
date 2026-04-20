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
    int ans = 0  ;
    public int longestZigZag(TreeNode root) {
        if(root == null) return 0 ;
        if(root.right == null && root.left == null) return 0 ;
        fun(root.left , 1 , false) ;
        fun(root.right , 1 , true) ;
        return ans ;
    }
    public void fun(TreeNode root , int len , boolean f){
        if(root == null) return ;
        ans = Math.max(ans , len) ;
        if(!f){
            fun(root.right , len + 1 , true) ;
            fun(root.left , 1 , false) ;
        }
        else {
            fun(root.left , len + 1 , false) ;
            fun(root.right , 1 ,true) ;
        }
    }
}