class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length ;
        int m = img1[0].length  ;
        List<int[]> a = new ArrayList<>() ;
        List<int[]> b = new ArrayList<>() ;
        for(int i = 0 ; i  < n ;i++){
            for(int j = 0 ; j < m ;j++){
                if(img1[i][j] == 1){
                    a.add(new int[]{i , j});
                }
                if(img2[i][j] ==1){
                    b.add(new int[]{i , j}) ;
                }
            }
        }
        HashMap<String , Integer> map = new HashMap<>() ;
        int ans   = 0  ;
        for(int p[]  : a){
            for(int []q : b){
                int c = p[0] - q[0] ;
                int d = p[1] - q[1] ;
                String s = c + "," + d ;
                map.put(s , map.getOrDefault(s , 0) +1) ;
                ans = Math.max(ans , map.get(s)) ;
            }
            
        }
        return ans ;
    }
}