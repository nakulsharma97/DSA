class Solution {
    public int minimumDistance(int[] nums) {
            HashMap<Integer ,List<Integer>> map = new HashMap<>() ;
            int n = nums.length ;
            int res = Integer.MAX_VALUE ;
            for(int i = 0 ;i < n ;i++){
                int num = nums[i] ;
                List<Integer> list = map.getOrDefault(num , new ArrayList<>()) ;
                if(list.size() == 2){
                    int val1  = list.get(0) ;
                    int val2 = list.get(1) ;
                    int val3 = i ;
                    int dist = Math.abs(val1 - val2) + Math.abs(val2 - val3) + Math.abs(val3 - val1) ;
res = Math.min(res , dist) ;
list.set(0 , val2)  ;
list.set(1 , val3) ;

                }
                else {
                    list.add(i);
                }
                map.put(num , list) ;
            }
           return res!=Integer.MAX_VALUE?res:-1;
    }
}