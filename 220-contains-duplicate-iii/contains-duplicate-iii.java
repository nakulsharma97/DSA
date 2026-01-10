class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> tree = new TreeSet<>() ;
        for(int i = 0 ; i < nums.length ; i++){
            Long el = new Long(nums[i]) ;
            Long floor = tree.floor(el) ;
            Long ceil = tree.ceiling(el) ;
            if(floor != null && Math.abs(floor - el) <= valueDiff){
                return true  ;
            }
            if(ceil != null && Math.abs(ceil - el) <= valueDiff){
                return true ;
            }
            tree.add(el) ;
            if(tree.size() > indexDiff){
                tree.remove(new Long(nums[i-indexDiff])) ;
            }
        }
        return false ;
    }
}