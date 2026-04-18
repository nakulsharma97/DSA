class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int res = Integer.MAX_VALUE ;
        HashMap<Integer , Integer> map = new HashMap<>() ;
        int n = nums.length ;
        for(int i = 0 ;i < n ;i++){
            if(map.containsKey(nums[i])){
                res = Math.min(res , i - map.get(nums[i])) ;
            }
            map.put(reverse(nums[i]) , i) ;
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    public int reverse(int n){
        int rev = 0 ;
        while(n >  0){
            rev = rev * 10 + n % 10 ;
            n = n / 10 ;
        }
        return rev ;
    }
}