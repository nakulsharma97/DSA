class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

       
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] t : times) {
            adj.get(t[0]).add(new int[]{t[1], t[2]});
        }
         // (node , time)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] - b[1]
        );

        // Step 3: Distance array
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;
        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int time = curr[1];

            if (time > dist[node]) continue;

            for (int[] nei : adj.get(node)) {
                int next = nei[0];
                int wt = nei[1];

                if (time + wt < dist[next]) {
                    dist[next] = time + wt;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }

        // Step 5: Find result
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            res = Math.max(res, dist[i]);
        }

        return res;
    }
}