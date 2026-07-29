class Solution {
    public boolean onediff(String a, String b) {
        int diff = 0;
        for (int i = 0; i < 8; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        if(startGene.equals(endGene)){
            return 0 ;
        }
        int n = bank.length;
        ArrayList<String> list = new ArrayList<>();
        list.add(startGene);
        for (String s : bank) {
            list.add(s);
        }
        
        int m = list.size();
        ArrayList<ArrayList<Integer>> l = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            l.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                if (onediff(list.get(i), list.get(j))) {
                    l.get(i).add(j);
                    l.get(j).add(i);
                }
            }
        }
        int end = -1;
        for (int i = 0; i < m; i++) {
            if (list.get(i).equals(endGene)) {
                end = i;
                break ;
            }
        }
        if (end == -1) {
            return -1;
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[m];
        q.offer(0);
        vis[0] = true;
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int node = q.poll();
                if (node == end) {
                    return level;
                }
                for (int i : l.get(node)) {
                    if (!vis[i]) {
                        vis[i] = true;
                        q.offer(i);
                    }
                }
            }
            level++;
        }
        return -1;
    }
}