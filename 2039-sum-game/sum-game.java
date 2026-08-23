class Solution {
    public boolean sumGame(String num) {
        int n = num.length() ;
        int leftsum = 0;
        int rightsum = 0 ;
        int left = 0 ;
        int right = 0 ;
        for(int i = 0 ; i < n / 2 ;i++){
            if(num.charAt(i) == '?'){
                left++ ;
            }
            else {
                leftsum += num.charAt(i) - '0' ;
            }
        }
         for(int i = n/2 ; i < n ;i++){
            if(num.charAt(i) == '?'){
                right++ ;
            }
            else {
                rightsum += num.charAt(i) - '0' ;
            }
        }
         
         if((left + right) % 2 == 1){
            return true  ;
         }
         return leftsum - rightsum != (right - left) * 9 / 2 ;

    }
}