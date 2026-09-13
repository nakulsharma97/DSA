class Solution {
    public int countSpecialIntegers(int[] nums) {
        int  n = nums.length ;
        HashMap<Integer , List<Integer>> map = new HashMap<>() ;
        for(int i = 0 ; i < n ; i++){
            map.putIfAbsent(nums[i] , new ArrayList<>()) ;
            map.get(nums[i]).add(i) ;
        }
        int ans = 0  ;
        for(int key : map.keySet()){
            List<Integer> list = map.get(key)  ;
            if(list.size()  < 3){
                continue ;
            }
            int diff = list.get(1) - list.get(0) ;
            boolean spe = true ;
            for(int i = 2 ; i < list.size() ;i++){
                if(list.get(i) - list.get(i-1)  != diff){
                    spe = false ;
                }
            }
            if(spe){
                ans++ ;
            }
        }
        return ans ;
    }
}