class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int [] ar = arr.clone() ;
        Arrays.sort(ar) ;
        int n = arr.length ;
        int ans[] = new int[n] ;
        HashMap<Integer , Integer> map = new HashMap<>() ;
        int rank = 1 ;
        for(int i : ar){
            if(!map.containsKey(i)){
                map.put(i , rank) ;
                rank++ ;
            }
        }
        for(int i = 0 ; i < n ;i++){
            ans[i] = map.get(arr[i]) ;
        }
        return ans  ;
    }
}