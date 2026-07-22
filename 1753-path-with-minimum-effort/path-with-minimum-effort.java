class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length ;
        int n = heights[0].length ;
        int[][] efforts = new int[m][n] ;
        for(int row[] : efforts){
            Arrays.fill(row , Integer.MAX_VALUE) ;
        }
        efforts[0][0] = 0  ;
        PriorityQueue<int[] > pq = new PriorityQueue<>( (a , b) -> a[0] - b[0]) ;
        pq.offer(new int[]{0 , 0 , 0}) ;
        int dir[][]  ={
            {0 , -1},
            {-1 , 0},
            {1 , 0},
            {0 , 1}
        } ;
        while(!pq.isEmpty()){
            int curr[] = pq.poll() ;
            int effort = curr[0] ;
            int row = curr[1] ;
            int col = curr[2] ;
            for(int d[] : dir){
                int nr = row + d[0] ;
                int nc = col + d[1] ;
                if(nr >= 0 && nr < m && nc >= 0 && nc < n){
                    int edge = Math.abs(heights[nr][nc] - heights[row][col]) ;
                    int eff = Math.max(effort , edge) ;
                    if(eff < efforts[nr][nc]){
                        efforts[nr][nc] = eff  ;
                        pq.offer(new int[]{eff , nr , nc}) ;
                    }
                }
            }

        }
        
        return efforts[m-1][n-1] ;
    }
}