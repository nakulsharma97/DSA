class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length ;
        int sum = 0 ;
        for(int i = 0 ; i < n;i++){
            sum += nums[i] ;
        }
        if(n == 1){

            return true ;
        }
        int player1 = solve(0 , n-1 , nums) ; 
       return player1 >= sum - player1;
    }
    public int solve(int i , int j , int[] nums){
        if(i > j){
            return 0 ;
        }
        int takefirst = nums[i] + Math.min(solve(i + 2 , j , nums) , solve(i + 1 , j- 1 , nums)) ;
        int takeend = nums[j] + Math.min(solve(i , j - 2 , nums) , solve(i + 1 , j - 1 , nums)) ;
      return Math.max(takefirst , takeend) ;
    }
}