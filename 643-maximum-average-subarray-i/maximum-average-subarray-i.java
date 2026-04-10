class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n =nums.length ;
       // int p = k-1  ;
        long res = 0 ;

        for(int i = 0  ;i < k ;i++){
            res += nums[i] ;
        }
     long  maxx= res ;
        for(int i = k ;i < n ;i++){
            res +=   nums[i] - nums[i-k] ;
            maxx = Math.max(res ,maxx )  ;
        }
        return (double) maxx / k ;
    }
}