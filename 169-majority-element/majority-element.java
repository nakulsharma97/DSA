class Solution {
    public int majorityElement(int[] nums) {
        int maj =  0 ;
        int n = nums.length ;
        int nn = n/ 2 ;
        HashMap<Integer, Integer> map = new HashMap<>() ;
        for(int i = 0 ; i < n ;i++ ){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if(map.get(nums[i]) > nn){
                return nums[i] ;
            }

        }
        return -1 ;

    }
}