class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        HashMap<Integer , List<Integer>> map = new HashMap<>() ;
        int n = nums.length ;
        for(int i = 0 ;i < n ;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i] , new ArrayList<>()) ;
            }
                map.get(nums[i]).add(i) ;
            
        }
        List<Integer> ans = new ArrayList<>() ;
        for(int q : queries){
            List<Integer> list = map.get(nums[q]) ;
             if(list.size() == 1){
                ans.add(-1) ;
                continue ;
             }
           int pos = Collections.binarySearch(list, q);

            int res = Integer.MAX_VALUE;

     int right = list.get((pos + 1) % list.size()) ;
     int d = Math.abs(right - q) ;
     res = Math.min(res , Math.min( d , n - d)) ;
      
int left = list.get((pos - 1 + list.size()) % list.size());
int d1 = Math.abs(left - q) ;
res = Math.min( res , Math.min(d1 , n - d1)) ;
 
ans.add(res) ;
        }
        return ans ;
    }
}