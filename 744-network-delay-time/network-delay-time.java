class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>() ;
        for(int i = 0 ; i <= n ;i++){
            adj.add(new ArrayList<>()) ;
        }
        for(int t[]  : times){
            adj.get(t[0]).add(new int[] {t[1] , t[2]}) ;
        }
        int[] mint = new int[n + 1] ;
        Arrays.fill(mint , Integer.MAX_VALUE) ;
        mint[k] = 0 ;
        PriorityQueue<int[] > pq = new PriorityQueue<>(
            (a , b) -> a[1] - b[1]
        )  ;
        pq.offer(new int [] {k , 0}) ;
        while(!pq.isEmpty()){
            int size = pq.size() ;
            while(size-- > 0){
                int curr[] = pq.poll() ;
                for(int neigh[] : adj.get(curr[0])) {
                       int next = neigh[0] ;
                       int time = neigh[1] ;
                       if( curr[1] + time >= mint[next]){
                        continue ;
                       }
                       mint[next] = curr[1] + time ;
                       pq.offer(new int[]{next , curr[1] + time}) ;

                }

            }
        }
        int res = 0 ;
        for(int i = 1 ; i <= n ;i++){
            if(mint[i] == Integer.MAX_VALUE){
                return -1 ;
            }
            res = Math.max(res , mint[i]) ;
        }
        return res ;
    }

}