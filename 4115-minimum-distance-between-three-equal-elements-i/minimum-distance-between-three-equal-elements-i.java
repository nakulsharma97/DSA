class Solution {
    public int minimumDistance(int[] nums) {
        List<Integer>[] arr = new ArrayList[101];
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[nums[i]] == null) {
                arr[nums[i]] = new ArrayList<>();
            }
            arr[nums[i]].add(i);
        }
        for(List<Integer> l :  arr){
            if(l != null && l.size() >= 3){
                for(int i = 2 ;i < l.size() ;i++){
                    int dist = l.get(i)  + l.get(i) - l.get(i-2) - l.get(i-2) ;
                    res = Math.min(dist ,res) ;
                }
            }
        }
        return (res  == Integer.MAX_VALUE) ? -1 : res ;
    }
}