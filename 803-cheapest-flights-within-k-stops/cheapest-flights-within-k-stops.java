class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int flight[] : flights) {
            adj.get(flight[0]).add(new int[] { flight[1], flight[2] });
        }
        Queue<int[]> q = new LinkedList<>();
        int mincost[] = new int[n];
        Arrays.fill(mincost, Integer.MAX_VALUE);
        q.offer(new int[] { src, 0 }); // 0 = prize;
        int stop = 0;
        while (!q.isEmpty() && k >= stop) {
            int size = q.size();
            while (size-- > 0) {
                int curr[] = q.poll();
                for (int neigh[] : adj.get(curr[0])) {
                    if (curr[1] + neigh[1] >= mincost[neigh[0]]) {
                        continue ;
                    } 
                    mincost[neigh[0]]  = curr[1] + neigh[1] ;
                q.offer(new int[] { neigh[0], curr[1] + neigh[1] });

                }

            }
            stop++;

        }
        return mincost[dst] == Integer.MAX_VALUE ? -1 : mincost[dst];
    }
}