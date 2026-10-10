class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length  ;
        long d[] = new long[100001] ;
        long sum = 0 ;
        int max = 0 ;
        long k = (long) k1 + k2 ;
        for(int i = 0 ; i < n ;i++){
            int x = Math.abs(nums1[i] - nums2[i]) ;
            sum += x ; 
            max = Math.max(max , x) ;
            d[x]++ ;
        }
        if(sum <= k){
            return 0  ;
        }
        for(int i = max ; i > 0 && k > 0 ;i--){
            long move = Math.min(d[i] , k) ;
            d[i] = d[i] - move ;
            d[i-1] = d[i-1] + move ;
            k = k - move ; 
        }

        long ans = 0 ;
        for(int i = 0 ; i <= max ;i++){
            ans += (long) i * i* d[i] ;
        }
        return ans  ;

    }
}