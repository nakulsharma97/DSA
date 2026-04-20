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
        List<Integer> leaf1 = new ArrayList<>() ;
        List<Integer> leaf2 = new ArrayList<>() ;
        height(leaf1 , root1) ;
        height(leaf2 , root2)  ;
        return leaf1.equals(leaf2) ? true : false ;

    }
    public void height(List<Integer> leaf , TreeNode root){
        if(root == null) return ;
        if(root.right == null && root.left == null){
            leaf.add(root.val) ;
            return ;
        }
        height(leaf , root.right) ;
        height(leaf ,root .left) ;
    }
}