class Solution {
    int ways = 0 ;
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length ;
        dfs(nums , 0 , 0 , target) ;
        return ways ;
    }
    void dfs(int []nums , int idx , int sum , int target){
        if(idx == nums.length){
            if(sum == target){
                ways++ ;
            }
            return  ;
        }
        dfs(nums , idx + 1 , sum +  nums[idx] , target) ;
        dfs(nums , idx + 1 , sum - nums[idx] , target) ;
    }
}