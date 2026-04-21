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
    public List<Integer> rightSideView(TreeNode root) {
       
        Queue<TreeNode>  q = new LinkedList<>() ;
        List<Integer> list = new ArrayList<>() ;
         if(root == null) return list ;
        q.offer(root) ;
        while( !q.isEmpty()){
            int size = q.size() ;
            while(size > 0){
                TreeNode node = q.poll() ;
                if(node.left != null){
                    q.offer(node.left) ;
                }
                if(node.right != null){
                    q.offer(node.right) ;
                }
                size-- ;
                if(size == 0){
                    list.add(node.val) ;
                }
            }

        }
        return list ;
    }
}