class Solution {
    public int gcd (int even , int odd){
        while(odd != 0){
            int temp = odd ;
            odd = even % odd ;
            even = temp  ;
        }
        return even ;
    }
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int mx[] = new int[n];
        mx[0] = nums[0];
        for (int i = 1; i < n; i++) {
            mx[i] = Math.max(mx[i - 1], nums[i]);
        }
        int[] prefix = new int[n];
        for (int i = 0; i < n; i++) {
            if(nums[i] == mx[i]){
                prefix[i] = nums[i] ;
                continue  ;
            }
           prefix[i] = gcd(nums[i] , mx[i]) ;
        }
        Arrays.sort(prefix) ;
        int ans[] = new int[n/2] ;
        for(int i = 0 ; i < (n/2)   ;i++){
           ans[i] = gcd(prefix[i] , prefix[n - 1 - i]) ;
        } 
        
        long result = 0 ;
        for(int i = 0 ; i < ans.length ;i++){
            result += (long) ans[i] ;
        }
 return result ;
    }
}