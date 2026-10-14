class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length ;
        HashSet<Integer> set = new HashSet<>() ;
        for(int i = 0 ; i < n ;i++){
            set.add(nums[i]) ;
        }
        int ans = 0  ;
        for(int s : set){
            if(!set.contains(s-1)){
                int max = 1;
                int cur = s ;
                while(set.contains(cur + 1)){
                    cur++ ;
                    max++ ;
                }
                ans = Math.max(ans , max) ;
            }
        }
        return ans  ;
    }
}