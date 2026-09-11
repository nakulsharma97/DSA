class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length ;
        int max = nums[0] ;
        int arr[] = new int[n] ;
        arr[0] = nums[0] ;
        for(int i = 1  ; i < n ; i++){
            arr[i] = Math.max(nums[i] , arr[i-1] + nums[i]) ;
            max = Math.max(arr[i] , max) ;
        }
        return max ;
    }
}