class FindSumPairs {

    int nums1[] ;
    int nums2[] ;
    HashMap<Integer  , Integer> map1 = new HashMap<>() ;
    HashMap<Integer , Integer> map2 = new HashMap<>() ;
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1 ;
        this.nums2 = nums2 ;
        for(int num : nums1){
            map1.put(num , map1.getOrDefault(num , 0) +1) ;
        }
        for(int num : nums2 ){
            map2.put(num , map2.getOrDefault(num , 0)+1) ;
        }
        
    }
    
    public void add(int index, int val) {
        int odd = nums2[index] ;
        map2.put(odd , map2.get(odd) -1) ;
        int ne = odd + val ;
        nums2[index] = ne ;
        map2.put(ne , map2.getOrDefault(ne , 0)+1) ;
    }
    
    public int count(int tot) {
      int ans   =0 ;
        for(int num : nums1){
            int val = tot - num ;
            {
                if(map2.containsKey(val)){
                     ans += map2.get(val) ;
                    
                }
                
            }
        }
        return ans  ;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */