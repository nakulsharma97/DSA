class Solution {
    static class Pair{
        int sum ;
        int i ;
        int j ;
        Pair(int sum ,int i , int j){
            this.sum = sum ;
            this.i = i ;
            this.j = j  ;
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>() ;
        int n = nums1.length ;
        int m = nums2.length ;
     if(n == 0 || m == 0 || k == 0){
        return result ;
     }
     Set<String> vis = new HashSet<>() ;
     PriorityQueue<Pair> p = new PriorityQueue<>((a , b) -> a.sum - b.sum) ;
     p.offer(new Pair(nums1[0] +  nums2[0] , 0 , 0));
     vis.add("0,0") ;
     while(k-- > 0 && !p.isEmpty()){
        Pair curr = p.poll() ;
        int i = curr.i  ;
        int j = curr.j ;
        result.add(Arrays.asList(nums1[i] , nums2[j])) ;
        if(j + 1 < m && !vis.contains(i + "," +(j+1))){
            p.offer(new Pair(nums1[i] + nums2[j+1] , i , j +1 ) ) ;
            vis.add(i + "," + (j+1)) ;
        }
        if(i + 1 <  n && !vis.contains((i+1) + "," + j)){
            p.offer(new Pair(nums1[i+1] + nums2[j] , (i + 1), j)) ;
           //  result.add(Arrays.toList( i +1 , j)) ;
            vis.add((i +1) + "," + j) ;
        }
     }
     return result ;
    }
}