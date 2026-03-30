class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        for (int[] pre : prerequisites)
            adj.get(pre[1]).add(pre[0]);

        int[] state = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0 && dfs(i, adj, state)) return false;
        }

        return true;
    }

    private boolean dfs(int node, List<List<Integer>> adj, int[] state) {
        state[node] = 1; // visiting

        for (int next : adj.get(node)) {
            if (state[next] == 0) {
                if (dfs(next, adj, state)) return true;
            } 
            else if (state[next] == 1) {
                return true; // cycle found
            }
        }

        state[node] = 2; // visited
        return false;
    }
}