class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>() ;
        int n = nums.length ;
        boolean used[] = new boolean[n] ;
        List<Integer> list = new ArrayList<>() ;
        solve(ans ,nums , used , list ,0 , n ) ;
        return ans ;
    }
    public void solve(List<List<Integer>> ans , int [] nums,  boolean [] used , List<Integer> list , int a, int n){
        if(list.size() == n){
            ans.add(new ArrayList<>(list));
        }
        for(int i = 0 ; i < n ;i++){
            if(used[i]){
                continue ;
            }
            used[i]= true ;
            list.add(nums[i]) ;
            solve(ans ,nums , used , list , i , n) ;
            list.remove(list.size()  -1) ;
            used[i] = false ;
        }

    }
}