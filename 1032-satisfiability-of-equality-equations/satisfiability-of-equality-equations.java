class Solution {
    int rank[];
    int parent[];

    int find(int u) {
        if (u == parent[u]) {
            return u;
        }
        parent[u] = find(parent[u]);
        return parent[u];
    }

    void union(int x , int y){
        int parentx = find(x) ;
        int parenty = find(y) ;
        if(rank[parentx] < rank[parenty]){
            parent[parentx] = parenty ;
        }
        else if(rank[parenty] < rank[parentx]){
            parent[parenty] = parentx ;
        }
        else {
            parent[parenty] = parentx ;
            rank[parentx]++ ;
        }
     }

    public boolean equationsPossible(String[] equations) {
        rank = new int[26];
        parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        for (String s : equations) {
            char ch = s.charAt(1);
            char u = s.charAt(0);
            char v = s.charAt(3);
            if (ch == '=') {
                union(u - 'a', v - 'a');
            }
        }
        for(String s : equations){
            char ch = s.charAt(1) ;
            char u = s.charAt(0);
            char v = s.charAt(3) ;
             if (ch == '!') {
                int parentu = find(u - 'a');
                int parenty = find(v - 'a');
                if (parentu == parenty) {
                    return false;
                }
            }
        }
        return true;
    }
}