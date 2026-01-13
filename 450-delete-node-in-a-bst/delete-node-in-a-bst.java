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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
       else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        else { 
            // fount the root 
            if(root.right == null) return root.left ;
            else if(root.left == null) return root.right ;

            root.val =minValue(root.right) ;// it is delete the value we want to delete , and setting the minimum value of the right tree
            root.right = deleteNode(root.right , root.val) ; // it will delete the minvalue from the right tree ;

        }
        return root ;
    }
    public int minValue(TreeNode root){
        int minv = root.val;
        while(root.left != null){
            minv = root.left.val ;
            root = root.left ;
        }
        return minv ;
    }
}