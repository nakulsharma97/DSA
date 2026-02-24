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
    public int  dfs(TreeNode rt , int x){
        if(rt == null) return 0 ;
        x = x*2 + rt.val ;
        if(rt.left == rt.right) return x ;
        return dfs(rt.left , x) + dfs(rt.right , x) ;

    }
    public int sumRootToLeaf(TreeNode root) {
   return  dfs(root , 0) ;
}
}