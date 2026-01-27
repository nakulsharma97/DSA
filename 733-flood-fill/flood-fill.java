class Solution {
    int rows , cols ;
    void dfs(int row ,int col , int color , int curcolor,boolean visited[][] , int image[][]){
        // out of bound 
        if(row <0 || row >= rows || col < 0 || col >= cols){
            return ;
        }
        // if color not present 
        if(image[row][col] != curcolor){
            return ;
        }
        // node already visited
        if(visited[row][col]){
            return ;
        }
        image[row][col] = color ;
        visited[row][col] = true ;
        // neighbours 
        int adjlist[][] = {
            {row-1, col}, {row , col+1},{ row+1,col}, {row, col -1} 
        } ;
        for(int  nei[] :  adjlist){
            dfs( nei[0] ,nei[1] ,  color ,  curcolor,visited, image) ;
        }



    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rows = image.length;
        cols = image[0].length ;
        boolean[][] visited = new boolean[rows][cols] ;
        dfs(sr, sc ,color , image[sr][sc], visited, image ) ;
        return image ;
    }
}