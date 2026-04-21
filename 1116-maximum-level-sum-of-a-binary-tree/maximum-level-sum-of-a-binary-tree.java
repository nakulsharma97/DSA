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
    public int maxLevelSum(TreeNode root) {
        int level = 1;
        int maxl = 1;
        int maxs = Integer.MIN_VALUE;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size() ;
            int sum = 0;
            while( size > 0){
                TreeNode node = q.poll() ;
                if(node.left != null){
                    q.offer(node.left) ;
                }
                if(node.right != null){
                    q.offer(node.right) ;
                }
                sum = sum + node.val ;
                size-- ;
                if(size == 0){
                    if( sum > maxs){
                        maxs= sum ;
                        maxl = level ;
                    }
                    level++ ;
                }
                
            }

        }
        return maxl ;

    }
}