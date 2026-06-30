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
        List<List<Integer>> ll = new ArrayList<>() ;
        if(root == null){
          return ll ;
        }
        Queue<TreeNode> q = new LinkedList<>() ;
        q.offer(root) ;
        boolean leftt = true ;
        while(!q.isEmpty()){
            int size = q.size() ;
            List<Integer> l = new ArrayList<>() ;
            for(int i =0 ; i< size ;i++){
                TreeNode p = q.poll() ;
                l.add(p.val) ;
                if(p.left != null){
                    q.offer(p.left) ;
                }
                 if(p.right != null){
                    q.offer(p.right) ;
                }
            }
            if(leftt == false){
                Collections.reverse(l) ;
            }
            ll.add(l) ;
            leftt = !leftt ;
        
        }
        return ll ;
    }
}