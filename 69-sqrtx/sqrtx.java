class Solution {
    public int mySqrt(int x) {
        if( x < 2) return x;
        int count = 0 ;
        for(int i = 1 ; i <= x/i ;i++){
            count++ ;
        }
        return count ;
    }
}