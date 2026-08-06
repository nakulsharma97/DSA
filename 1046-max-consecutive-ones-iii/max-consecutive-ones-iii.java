class Solution {
    public int longestOnes(int[] nums, int k) {
        int n =  nums.length ;
        int right = 0 ;
        int left = 0 ;
        int maxl = 0 ;
        int zero = 0 ;
        while(right < n){
            if(nums[right] == 0){
               zero++ ;
            }
            if(zero > k){
                if(nums[left] == 0){
                    zero-- ;
                }
                left ++ ;
            }
            if(zero <= k){
                maxl = Math.max(maxl , right - left +1) ;
            }
            right++ ;
        }
        return maxl ;
    }
}