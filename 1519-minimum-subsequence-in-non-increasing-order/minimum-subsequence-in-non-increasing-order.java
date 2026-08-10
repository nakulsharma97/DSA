class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> ans = new ArrayList<>() ;
        int n = nums.length ;
        int total =  0 ;
        for(int i = 0 ; i < n ;i++){
            total += nums[i] ;
        }
        Arrays.sort(nums) ;
        int i = 0 ;
        int j = n-1 ;
        int front = nums[0] ;
        int last = nums[n-1] ;
        ans.add(nums[n-1]) ;
        while( i < j){
            if(front >= last){
                j-- ;
                ans.add(nums[j]) ;
                last += nums[j] ;
            }
            else{
                i++;
                front += nums[i] ;
            }
        }
        return ans  ;
    }
}