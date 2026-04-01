class Solution {
    public boolean rootToLeafPathSum(TreeNode root, int targetSum, int sum){
        if(root == null)
            return false;
            sum = sum + root.val;
        if(root.left == null && root.right == null){
            
            if(sum == targetSum)
                return true;   
        }
        return rootToLeafPathSum(root.left, targetSum, sum ) || rootToLeafPathSum(root.right, targetSum, sum );
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum = 0;
        return rootToLeafPathSum(root, targetSum, sum);
    }
}