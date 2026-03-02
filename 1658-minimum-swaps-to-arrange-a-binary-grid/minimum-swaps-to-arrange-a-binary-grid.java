class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length ;
        int[] zeroes = new int[n] ;
        // in this we are counting the number of zeroes at the end of rows
        for(int i = 0 ; i < n ;i++){
            int count = 0 ; 
            for(int j = n -1 ;  j >= 0  && grid[i][j] == 0 ; j--){
                count++ ;
            }
            zeroes[i] = count ;
        } 
        // this the swaping of final answer
        int steps = 0 ;
        for(int i = 0 ; i < n ;i++){
            int needed = n - i - 1 ; // finding the need of  the rows , how many end zero should be their in that particular row
            int j = i ; // if that itself row has satisfy number of zeroes
            while( j < n && zeroes[j] < needed){
                j++ ; // if that row dont have the needed zeroes
            }
            if(j == n) return -1 ; // if any row dont have enough zeroes
            steps = steps + j - i ; //  counting the swaping steps 
            while( j > i){
                int temp = zeroes[j] ;
                zeroes[j] = zeroes[j-1] ; // swaping the  rows from each other
                zeroes[j-1] = temp ;
                j-- ;
                
            }
        }
        return steps ;
    }
}