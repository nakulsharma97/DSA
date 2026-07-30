class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length ;
        int m = heights[0].length ;
        int eff[][] = new int[n][m] ;
        for(int row[] : eff){
            Arrays.fill(row , Integer.MAX_VALUE) ;
        }
        eff[0][0] = 0  ;
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a , b) -> a[0] - b[0]) ;
        int dir[][] = {
            {0 , 1},
            {1, 0},
            {0 , -1},
            {-1 , 0}
        } ;
        pq.offer(new int[]{0, 0 , 0}) ;
        while(!pq.isEmpty()){
            int size = pq.size() ;
            while(size-- > 0){
                int curr[] = pq.poll() ;
                int e = curr[0] ;
                int i = curr[1] ;
                int j = curr[2] ;
                for(int d[] : dir){
                    int nx = i + d[0] ;
                    int ny = j + d[1] ;
                    if(nx >= 0 && nx < n && ny >= 0 && ny < m){
                        int effort = Math.abs(heights[nx][ny] - heights[i][j]) ;
                        int ef = Math.max(e , effort) ;
                        if(eff[nx][ny] > ef){
                            eff[nx][ny] = ef ;
                            pq.offer(new int[]{ ef , nx , ny}) ;
                        }
                    }
                }
            }
        }
        return eff[n-1][m-1] ;
    }
}