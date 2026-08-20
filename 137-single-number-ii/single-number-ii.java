class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length ;
        int res = 0 ;
        for(int i = 0 ; i < 32;i++){
            int bit = 0 ;
            for(int num : nums){
                if((num & (1 << i)) != 0){
                    bit++ ;
                }
            }
            if(bit % 3 != 0){
                res = res | (1 << i) ;
            }
        }
        return res  ;
    }
}