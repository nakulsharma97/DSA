class DSU {
    private int[] parent;
    private int[] size;
    private int numberOfComponents;

    public DSU(int n) {
        parent = new int[n];
        size = new int[n];
        numberOfComponents = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x) {
        if (x == parent[x])
            return x;

        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);

        if (xParent == yParent)
            return;

        if (size[xParent] > size[yParent]) {
            parent[yParent] = xParent;
            size[xParent] += size[yParent];
        } else if (size[xParent] < size[yParent]) {
            parent[xParent] = yParent;
            size[yParent] += size[xParent];
        } else {
            parent[xParent] = yParent;
            size[yParent] += size[xParent];
        }

        numberOfComponents -= 1;
    }

    public int maxSize() {
        return numberOfComponents;
    }
}

class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        DSU dsu = new DSU(n);
        HashMap<Integer, Integer> map = new HashMap<>() ;
        for(int i =0 ; i < n ;i++){
            for(int prime = 2 ; prime * prime <= nums[i] ;prime++){
                if(nums[i] % prime != 0){
                    continue ;
                }
                if(map.containsKey(prime)){
                    dsu.union(map.get(prime) , i) ;
                }
                else{
                    map.put(prime , i) ;
                }
                while(nums[i] % prime == 0){
                    nums[i] = nums[i] / prime ;
                }
            }
            if(nums[i] > 1){
                if(map.containsKey(nums[i])){
                     dsu.union(map.get(nums[i]) , i) ;
                }
                else {
                    map.put(nums[i], i);
                }
            }
        }
        return dsu.maxSize() == 1;
    }
}