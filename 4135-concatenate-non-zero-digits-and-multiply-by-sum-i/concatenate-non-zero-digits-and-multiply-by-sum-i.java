class Solution {
    public long sumAndMultiply(int n) {
        char ch[] = String.valueOf(n).toCharArray();
        int a = ch.length ;
        long x = 0 , sum = 0 ;
        long len = 1 ;
        for(int i = 0 ; i < a ;i++){
            if(ch[i] != '0'){
                x = x * 10 + (ch[i] - '0')  ;
                sum  += ch[i] - '0' ;
                len = len * 10 ;
            }
           
            
        }
        return x * sum ;

    }
}