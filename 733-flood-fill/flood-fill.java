class Solution {
    int rows, cols;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rows = image.length;
        cols = image[0].length;
        int curcolor = image[sr][sc];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        image[sr][sc] = color; // fill as well as visit 
        while (!q.isEmpty()) {
            int node[] = q.poll();
            int row = node[0];
            int col = node[1];
            int adjlist[][] = {
                    { row - 1, col }, { row, col + 1 }, { row + 1, col }, { row, col - 1 }
            };
            for (int nei[] : adjlist) {
                int r = nei[0];
                int c = nei[1];
                // out of bound 
                if (r < 0 || r >= rows || c < 0 || c >= cols) {
                    continue;
                }
                // if color not present 
                if (image[r][c] != curcolor || image[r][c] == color) {
                    continue;
                }
                
             q.offer(new int[]{r,c}) ;
             image[r][c] = color ;
            }
        }
       
        return image;
    }
}