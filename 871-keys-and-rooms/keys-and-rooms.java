class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean visited[] = new boolean[rooms.size()] ;
        Queue<Integer> q = new  LinkedList<>() ;
        q.offer(0) ;
        visited[0] = true ;
        while(!q.isEmpty()){
            int node = q.poll() ;
            for(int key : rooms.get(node)){
                if(!visited[key]){
                    visited[key] = true ;
                    q.offer(key) ;
                }
            }

        }
        for( boolean v : visited){
            if(!v){
                return false ;
            }
            
        }
        return true ;
    }
}