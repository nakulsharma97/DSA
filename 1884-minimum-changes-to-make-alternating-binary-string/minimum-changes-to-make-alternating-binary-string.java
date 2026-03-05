class Solution {
    public int minOperations(String s) {
        int misA= 0  ;// 01010
        int misB = 0  ;// 1010101 
        int n = s.length() ;
        for(int i = 0 ; i < n ;i++){
         char expect = (i % 2 == 0)? '0' : '1' ;
          if(expect != s.charAt(i)) {
            misB++ ;
          }
          else {
            misA++ ;
          }
        }
        return Math.min(misB , misA);
    }
}