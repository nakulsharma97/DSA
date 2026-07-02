class Solution {
    int n;
    int dir[][] = {
        {1 ,0} ,
        {-1 ,0} ,
        {0 , 1} ,
        {0 ,-1}
    } ;
    public boolean solve(int[][] dist ,int sf){
        Queue<int[]> q = new LinkedList<>() ;
        boolean visited[][] = new boolean[n][n] ;
        q.offer(new int[]{0 , 0}) ;
        visited[0][0] = true ;
        if(dist[0][0] < sf){
            return false ;
        }
        while(!q.isEmpty()){
            int curr[] = q.poll() ;
            int i = curr[0];
            int j = curr[1] ;
            if(i == n-1 && j == n-1) {
                return true;
            }
            for(int d[] : dir){
                int nr = i + d[0] ;
                int nc = j + d[1] ;
                if(nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc] ){
                    if(dist[nr][nc] < sf){
                        continue ;
                    }
                    q.offer(new int[]{nr , nc}) ;
                    visited[nr][nc] = true ;
                }

            }

        }
        return false ;
        
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        n = grid.size();
        int dist[][] = new int[n][n];
        boolean visited[][] = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    q.offer(new int[] { i, j });
                    visited[i][j] = true;
                }
            }
        }
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int curr[] = q.poll();
                int i = curr[0];
                int j = curr[1];
                dist[i][j] = level;
                for (int d[] : dir) {
                    int nr = d[0] + i;
                    int nc = d[1] + j;
                    if (nr < 0 || nr >= n || nc < 0 || nc >= n || visited[nr][nc]) {
                        continue;
                    }

                    q.add(new int[] { nr, nc });
                    visited[nr][nc] = true;
                }
            }
            level++;
        }

        int l = 0;
        int r = 400;
        int result =  0 ;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if(solve(dist, mid)){
                result = mid ;
                l = mid + 1 ;
            }
            else {
                r = mid - 1;
            }

        }
        return result ;
    }
}