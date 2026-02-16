class Solution {
    public int reverseBits(int n) {
        int res = 0 ;
        for(int i  = 0 ; i < 32 ; i++){
            res = res <<  1 ; // result left shift ho jaye , jis se usme space ban jayega
            res |= ( n & 1) ; // n & 1 = is used to take rightmost element  , res |= is used to add that rightmost in result int
            n = n >> 1 ; // yeh number ko right m shift kr dega jis se rightmost hat jayega
        }
        return res ;
    }
}