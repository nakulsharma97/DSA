class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length ;
        int res = 0 ;
        int al = 0 ;
        int arr[] = new int[n + 1] ;
        arr[0] = 0 ;
        for(int i = 1 ; i <=n ;i++){
            arr[i] = gain[i-1] + arr[i-1] ;
        }
        for(int i = 0 ; i <= n;i++){
            res = Math.max(res , arr[i]) ;
        }
        return res ;
    }
}