class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        // build graph
        for (int[] p : prerequisites) {
            adj[p[1]].add(p[0]);
        }

        int[] state = new int[n]; // 0=unvisited, 1=visiting, 2=done

        for (int i = 0; i < n; i++) {
            if (dfs(i, adj, state)) return false;
        }

        return true;
    }

    private boolean dfs(int node, List<Integer>[] adj, int[] state) {
        if (state[node] == 1) return true;   // cycle
        if (state[node] == 2) return false;  // already safe

        state[node] = 1; // mark visiting

        for (int next : adj[node]) {
            if (dfs(next, adj, state)) return true;
        }

        state[node] = 2; // mark done
        return false;
    }
}