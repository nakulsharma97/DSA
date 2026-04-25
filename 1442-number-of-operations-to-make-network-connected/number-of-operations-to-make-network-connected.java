class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) return -1 ;
        List<List<Integer>> adj = new ArrayList<>() ;
        int result = 0 ;
        boolean visited[] = new boolean[n] ;
        for(int i =  0 ; i < n ;i++){
            adj.add(new ArrayList<>()) ;
        }
        for(int conn[]  :connections){
            adj.get(conn[0]).add(conn[1]) ;
            adj.get(conn[1]).add(conn[0]) ;
        }
        for(int i = 0 ;i < n ;i++){
            if(!visited[i]){
                Queue<Integer> q = new LinkedList<>() ;
                result++ ;
                q.offer(i) ;
                visited[i] = true ;
                while(!q.isEmpty()) {
                    int node = q.poll() ;
                    for(int nei : adj.get(node)){
                        if(!visited[nei]){
                            visited[nei] = true ;
                            q.offer(nei) ;
                        }

                    }
                }
            }
        }

return result  - 1 ;
    }
}