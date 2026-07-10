class Solution {

    int[] parent;
    int[] size;

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path Compression
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) return;

        if (size[px] >= size[py]) {
            parent[py] = px;
            size[px] += size[py];
        } else {
            parent[px] = py;
            size[py] += size[px];
        }
    }

    public boolean equationsPossible(String[] equations) {

        parent = new int[26];
        size = new int[26];

        for (int i = 0; i < 26; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        // Process all equalities
        for (String s : equations) {
            if (s.charAt(1) == '=') {
                union(s.charAt(0) - 'a', s.charAt(3) - 'a');
            }
        }

        // Check inequalities
        for (String s : equations) {
            if (s.charAt(1) == '!') {
                if (find(s.charAt(0) - 'a') == find(s.charAt(3) - 'a')) {
                    return false;
                }
            }
        }

        return true;
    }
}