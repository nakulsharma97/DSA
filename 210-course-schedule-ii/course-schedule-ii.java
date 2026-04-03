class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int n = numCourses;

        // Step 1: Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 2: Build graph
        for (int[] ad : prerequisites) {
            adj.get(ad[1]).add(ad[0]);
        }

        // Step 3: Compute indegree
        int[] indegree = new int[n];
        for (int[] ad : prerequisites) {
            indegree[ad[0]]++;   // IMPORTANT FIX
        }

        // Step 4: Add nodes with indegree 0
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        // Step 5: BFS (Kahn’s Algorithm)
        int[] ans = new int[n];
        int idx = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            ans[idx++] = node;

            for (int nei : adj.get(node)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        // Step 6: Check for cycle
        if (idx == n) return ans;
        return new int[0];
    }
}