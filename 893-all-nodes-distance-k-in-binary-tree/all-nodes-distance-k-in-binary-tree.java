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
    HashMap<TreeNode, TreeNode> parent = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        buildparent(root , null);
        Set<TreeNode> visited = new HashSet<>();
        q.offer(target);
        visited.add(target);
        // int d = 0;
        while (!q.isEmpty() && k > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                 TreeNode node = q.poll();
                if (node.left != null && !visited.contains(node.left)) {
                    q.offer(node.left);
                    visited.add(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {

                    q.offer(node.right);
                    visited.add(node.right);
                }
                TreeNode par = parent.get(node);
                if (par != null && !visited.contains(par)) {
                    q.offer(par);
                    visited.add(par);
                }
               
            }

 k--;
        }
        for (TreeNode n : q) {
            res.add(n.val);
        }
        return res;
    }

    public void buildparent(TreeNode node, TreeNode par) {
        if (node == null){
            return;}
        parent.put(node, par);
        buildparent(node.left, node);
        buildparent(node.right, node);
    }
}