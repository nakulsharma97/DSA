class Solution {
    public int findMaxLength(int[] nums) {
     HashMap<Integer , Integer> map = new HashMap<>() ;
     map.put(0 , -1) ;
     int count = 0 ;
     int maxlen  = 0 ;
     int n = nums.length ;
     for(int i = 0 ; i < n;i++){
        count += (nums[i] == 1) ? 1 : -1 ;
        if(map.containsKey(count)){
            maxlen = Math.max(maxlen , i - map.get(count)) ;
        }
        else {

            map.put(count ,i) ;
        }
     }   
     return maxlen ;
    }
}