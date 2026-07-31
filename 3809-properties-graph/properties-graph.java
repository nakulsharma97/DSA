class Solution {
    public boolean common(int[] a, int[] b, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : a) {
            set.add(x);
        }
        int cnt = 0;
        HashSet<Integer> hash = new HashSet<>();
        for (int y : b) {
            if (set.contains(y) && !hash.contains(y)) {
                cnt++;
                hash.add(y);
            }
        }
        return cnt >= k;
    }

    public int numberOfComponents(int[][] properties, int k) {
        int n = properties.length;
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0 ;i< n ;i++){
            graph[i] = new ArrayList<>() ;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (common(properties[i], properties[j], k)) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
        int component = 0 ;
        boolean[] vis = new boolean[n];
         // Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {

            if (!vis[i]) {
                Queue<Integer> q = new LinkedList<>() ;
                component++;
                vis[i] = true;
                q.offer(i);
                while (!q.isEmpty()) {
                    int node = q.poll();
                    for (int nei : graph[node]) {
                        if (!vis[nei]) {
                            vis[nei] = true;
                            q.offer(nei);
                        }
                    }
                }
            }

        }
        return component;
    }

}
