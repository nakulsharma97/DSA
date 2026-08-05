class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        // HashSet<Integer> set = new HashSet<>() ;
        for (int i = 0; i < n; i++) {
            int a = manager[i];
            if (a == -1) {
                continue;
            } else {
                list.get(a).add(i);
            }

        }
        Queue<int[]> q = new LinkedList<>() ;
        q.offer(new int[]{headID , 0}) ;
        int ans =  0 ;
        while(!q.isEmpty()){
            int curr[] = q.poll() ;
            int u = curr[0] ;
            int time =curr[1] ;
            ans  = Math.max(ans , time) ;
            for(int nei : list.get(u)){
                q.offer(new int[]{nei , time + informTime[u]}) ;
            }
           
        }
        return ans  ;
    }
}