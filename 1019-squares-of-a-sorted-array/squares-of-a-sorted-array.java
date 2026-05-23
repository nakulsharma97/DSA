class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length ;
        int [] arr = new int[n] ;
        for(int i = 0 ; i < n ;i++){
            nums[i] = nums[i] * nums[i] ;
        }
    Arrays.sort(nums) ;
    return nums ;
    }
}