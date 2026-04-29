class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length ;
        int n = grid[0].length ;
        int freq[] = new int[m*n] ;
        int k = 0 ;
        for(int i = 0 ;i < m ; i++){
            for(int j = 0 ;j < n ; j++){
               freq[k] = grid[i][j]  ;
                k++ ;
            }

        }
        Arrays.sort(freq) ;
        int val = (m*n) / 2 ;
        int target = freq[val] ;
        int result = 0 ;
        for(int num : freq){
            if(num % x != target % x){
                return -1 ;
            }
            else {
                result += Math.abs(num - target) / x;
             }

        }
        return result ;
    }
}