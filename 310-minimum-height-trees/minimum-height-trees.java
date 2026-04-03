class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
    return Arrays.asList(0);
}
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int ad[] : edges) {
            adj.get(ad[0]).add(ad[1]);
            adj.get(ad[1]).add(ad[0]);
        }
        int degree[] = new int[n];
        for (int i = 0; i < n; i++) {
            degree[i] = adj.get(i).size();

        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                q.offer(i);
            }
        }
        while (n > 2) {
            int size = q.size();
            n -= size;
            for (int i = 0; i < size; i++) {
                 int leaf = q.poll();
                for (int neigh : adj.get(leaf)) {
                    degree[neigh]--;
                    if (degree[neigh] == 1) {
                        q.offer(neigh);
                    }
                }
            }
        }
        ArrayList<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            topo.add(q.poll());

        }
        return topo;
    }
}