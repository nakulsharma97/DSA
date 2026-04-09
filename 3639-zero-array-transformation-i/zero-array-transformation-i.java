class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length ;
        int diff[]  = new int[n] ;
        Arrays.fill(diff , 0) ;
        for(int q[] : queries){
            int start = q[0] ;
            int end = q[1] ;
            diff[start] += 1  ;
            if(end + 1 < n){
                diff[end + 1] -= 1 ;
            } 

        }
        for(int i = 1 ; i < n ; i++){
            diff[i] = diff[i-1] + diff[i] ;
        }
        for(int i = 0 ; i < n ;i++){
        int value = nums[i] - diff[i] ;
        diff[i] = value ;
        if(diff[i] < 0){
            diff[i] = 0  ;
        }
        }
        for(int i = 0 ;i< n ;i++){
            if(diff[i] != 0){
                return false ;
            }
        }
        return true ;
    }
}