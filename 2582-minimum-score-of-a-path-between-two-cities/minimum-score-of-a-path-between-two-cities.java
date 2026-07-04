class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ;i <= n ;i++){
            adj.add(new ArrayList<>()) ;
        }
        for (int road[] : roads) {
            int u = road[0];
            int v = road[1];
            int d = road[2];
            adj.get(u).add(new int[] { v, d });
            adj.get(v).add(new int[] { u, d });
        }
        boolean visited[] = new boolean[n + 1];
        q.offer(1);
        visited[1] = true;
        int ans = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int edge[] : adj.get(node)) {
                int nei = edge[0];
                int wt = edge[1];
                ans = Math.min(ans, wt);
                if (!visited[nei]) {
                    visited[nei] = true;
                    q.offer(nei);
                }
            }
        }
        return ans ;
    }

}