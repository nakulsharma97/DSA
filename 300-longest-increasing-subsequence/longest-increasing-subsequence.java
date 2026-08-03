class Solution {
    public int lengthOfLIS(int[] nums) {
     List<Integer> list = new ArrayList<>();
     int n = nums.length ;
     for(int num : nums){
        int low = 0 ;
        int high = list.size() -1 ;
        while(low <= high){
            int mid = low + (high - low ) / 2 ;
            if(list.get(mid) < num){
                low = mid + 1 ;
            }
            else {
             high = mid -1 ;
            }
        }
        if(low == list.size()){
            list.add(num) ;
        }
        else {
            list.set(low , num) ;
        }
     }   
     return list.size() ;
    }
}