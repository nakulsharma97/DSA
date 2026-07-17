class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        HashMap<Integer, Integer> child = new HashMap<>() ;
        HashMap<Integer , List<Integer>> parent = new HashMap<>() ;
        for(int i = 0 ; i< n;i++){
            int  node = i ;
            int left = leftChild[i] ;
            int right = rightChild[i] ;
            if(left != -1){
                parent.computeIfAbsent(node , k -> new ArrayList<>()).add(left) ;
                if(child.containsKey(left)){
                    return false;
                }
                else{
                child.put(left, node);
                }
            }
            if(right != -1){
                parent.computeIfAbsent(node , k -> new ArrayList<>()).add(right) ;
                if(child.containsKey(right)){
                    return false;
                }
                else {
                    child.put(right , node) ;
                }
            }
        }
        int root = - 1 ;
        for(int i =0 ; i<  n;i++){
            if(!child.containsKey(i)){
                if(root != -1){
                    return false ;
                }
                else {
                    root = i;
                }
            }
        }
        if(root == -1){
            return false ;
        }
        Queue<Integer> q  = new LinkedList<>() ;
        q.offer(root) ;
        boolean [] vis = new boolean[n] ; 
        int a = 1 ;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int childd : parent.getOrDefault(node , new ArrayList<>())){
                if(!vis[childd]){
                    vis[childd]= true ;
                    q.offer(childd) ;
                    a++ ;
                    
                }
            }
        }
        return a == n ;
    }
}