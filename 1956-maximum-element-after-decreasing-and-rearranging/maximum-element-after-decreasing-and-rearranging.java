class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length ;
        Arrays.sort(arr) ;
        int ans = 0 ;
        arr[0] = 1 ;
        for(int i = 1 ; i < n ;i++){
         if(arr[i] - arr[i -1] <= 1){
            continue ;
         }
         else if(arr[i] - arr[i-1] > 1){
            arr[i] = arr[i-1] + 1 ;
         }
            
        }
        int m = 0  ;
        for(int i  = 0 ; i< n ;i++){
            m = Math.max(m , arr[i]);
        }
        return m ;
    }
}