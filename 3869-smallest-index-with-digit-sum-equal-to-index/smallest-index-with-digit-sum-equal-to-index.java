class Solution {
    public int smallestIndex(int[] nums) {
        int n = nums.length ;
        int ans = 0 ;
        if( nums[0] == 0){
            return 0 ;
        }
        for(int i = 0 ; i < n;i++){
            int sum = 0 ;
            int a = nums[i] ;
            while(a > 0){
                int rem = a % 10 ;
                sum = sum + rem ;
                a = a / 10 ;
            }
            if(sum == i){
                ans = i ;
                break;
            }
        }
        return ans == 0 ? -1 : ans   ;
    }
}