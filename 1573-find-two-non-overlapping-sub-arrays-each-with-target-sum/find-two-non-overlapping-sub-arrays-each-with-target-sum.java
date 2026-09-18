class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length ;
        int best = n +1  ;
        int pre[] = new int[n] ;
        int suf[] = new int[n] ;
        Arrays.fill(pre , best) ;
        Arrays.fill(suf , best) ;
        int sum = 0  ;
        int j  = 0 ;
        for(int i = 0 ; i < n ;i++){
            sum += arr[i] ;
            while(sum > target){
                sum = sum - arr[j] ;
                j++ ;
            }
            if(target == sum){
                int len = i - j + 1 ;
                best = Math.min(best , len) ;
            }
            pre[i] = best ;
        }
        j = n-1 ;
        sum = 0 ;
        best = n+1 ;
         for(int i = n - 1 ; i >= 0 ;i--){
            sum += arr[i] ;
            while(sum > target){
                sum = sum - arr[j] ;
                j--  ;
            }
            if(target == sum){
                int len = j - i +1 ;
                best = Math.min(best , len) ;
            }
            suf[i] = best ;
        }
        int ans  = n+1;
        for(int i = 0 ; i < n - 1 ;i++){
         if(pre[i]  != n + 1 && suf[i + 1] != n+1){
            ans = Math.min(ans , pre[i] + suf[i+1]) ;
         }
     }
     return ans == n +1 ? -1 : ans  ;
    }
}