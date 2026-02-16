class Solution {
    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0;

        Queue<int[]> queue = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1) fresh++;
                else if(grid[i][j]==2) queue.offer(new int[]{i,j});
            }
        }

        int time = 0;

        while(!queue.isEmpty() && fresh>0){
            int size = queue.size();

            for(int i=0;i<size;i++){
                int[] rotten = queue.poll();
                int r = rotten[0], c = rotten[1];

                int[][] ne = {{r+1,c},{r-1,c},{r,c+1},{r,c-1}};

                for(int[] neigh : ne){
                    int nr = neigh[0];
                    int nc = neigh[1];

                    if(nr<0 || nr>=n || nc<0 || nc>=m) continue;

                    if(grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        queue.offer(new int[]{nr,nc});
                        fresh--;
                    }
                }
            }
            time++;
        }

        return fresh==0 ? time : -1;
    }
}
