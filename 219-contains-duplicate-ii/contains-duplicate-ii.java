class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length ;
    HashMap<Integer , Integer> map = new HashMap<>();
     for(int i = 0  ; i < n ; i++ ){
        int val = nums[i];
        if(map.containsKey(val) && i - map.get(val) <=k ){
            return true ;
        }
        map.put(val , i);

     } 
     return false ;  
    }
}