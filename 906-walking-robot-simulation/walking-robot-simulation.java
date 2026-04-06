class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>() ;
        int dir[][]  = {
            {0 , 1}, // north
            {1 , 0}, // east 
            {0, -1}, // south
        {-1, 0}  // west
        } ;
        int x = 0 , y = 0 , d = 0 ;
        int maxdir = 0 ;
        for(int [] o : obstacles){
            set.add(o[0] + "," + o[1]) ;
        }
        for(int cmd :  commands){
            if(cmd == -1){
                d = ( d + 1)  % 4 ;
            }
            else if( cmd == -2){
                d = ( d + 3 ) % 4 ;
            }
            else {
                for(int i = 0 ; i  < cmd ;i++){
                    int nx = x + dir[d][0] ;
                    int ny = y + dir[d][1] ;
                    
                    if(set.contains( nx + "," + ny)){
                        break ;
                    }
                    
      x = nx ;
      y = ny  ;
       maxdir = Math.max(maxdir , nx * nx + ny* ny) ;
                }
            }
        }
        return maxdir ;
    }
}