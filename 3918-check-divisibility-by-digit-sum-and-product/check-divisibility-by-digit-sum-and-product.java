class Solution {
    public boolean checkDivisibility(int n) {
        int ori = n  ;
        int sum = 0  ;
        int pro = 1  ;
        while(n > 0){
        int digit = n % 10  ;
        sum  = sum + digit ;
        pro = pro * digit ;
        n = n / 10 ;
        }
        int a = sum + pro ;
        if(ori % a == 0){
            return true ;
        }
        return false ;
    }
}