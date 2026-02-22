class Solution {
    public int binaryGap(int n) {
        int prev = -1 ;
        int ans = 0 ;
        for(int curr = 0 ; curr < 32 ;curr++){

            if(((n >> curr) & 1) > 0){
                ans = (prev != -1) ?Math.max(ans , curr - prev) : ans ;
                prev = curr ;
            }

        }
         return ans ;
    }
}