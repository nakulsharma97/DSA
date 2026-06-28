class Solution {
    public int maximumLength(int[] nums) {
     int n = nums.length ;
     HashMap<Integer, Integer> map = new HashMap<>();
     for(int i = 0 ; i < n  ;i++){
        map.put(nums[i] , map.getOrDefault(nums[i] , 0) +1) ;
     }   
     int ans = 0 ;
     if(map.containsKey(1)){
        int s = map.get(1) ;
        ans = (s % 2 == 0) ? s - 1 : s  ;
        map.remove(1) ;
     }
     for(int x : map.keySet()){
        int curr = x ;
        int len = 0 ;
        while(map.getOrDefault(curr , 0) >= 2){
            curr = curr * curr ;
            len = len +2  ;
        }
        if(map.containsKey(curr)){
            len++;
        }
        else {
            len-- ;
            
        }
        ans = Math.max(ans , len) ;
     }

return ans  ;
    }
}