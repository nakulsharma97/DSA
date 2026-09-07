class Solution {
    public int countGroups(int[] position, int[] speed, int distance) {
        int n = position.length ; 
        Deque<Integer> q = new ArrayDeque<>() ;
        for(int i = 0 ; i < n ;i++){
            if(i > 0 && position[i]  - position[i -1]  <= distance){
                q.pop() ;
            }
            q.push(speed[i]) ;
        }
        int ans = 0  ;
        int minspeed = Integer.MAX_VALUE ;
        for(int i = q.size()  - 1 ; i >= 0 ;i--){
            int a = q.pop() ;
            if(a <= minspeed ){
                ans++ ;
                minspeed = a ;
            }
        }
        return ans  ;
    }
}