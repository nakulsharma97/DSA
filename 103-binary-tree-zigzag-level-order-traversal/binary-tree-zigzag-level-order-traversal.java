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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>() ;
        Queue<TreeNode> q = new LinkedList<>() ;
        if(root == null){
            return list;
        }
        q.offer(root) ;
        int level = 0 ;
        while(!q.isEmpty()){
            int size = q.size() ;
            List<Integer> l = new LinkedList<>() ;
            while(size > 0){
                TreeNode node = q.poll() ;
               if(level % 2 ==  0){
                l.addLast(node.val) ;
               }
               if(level % 2 != 0){
                l.addFirst(node.val) ;
               }
               if(node.left != null){
                q.offer(node.left) ; 
               }
               if(node.right != null){
                q.offer(node.right) ;
               }
               size -- ;
            }
            level++ ;
            list.add(l) ;
        }
        return list ;
    }
}