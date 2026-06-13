class Solution {
    public String orderlyQueue(String s, int k) {
        int n = s.length() ;
        if( k > 1){
            char[] c = s.toCharArray() ;
            Arrays.sort(c) ;
            return new String(c);
        }
        String ans = s  ;
        for(int i =  1  ; i < n ;i++){
            String rotated = s.substring(i) + s.substring(0 , i ) ;
            if(rotated.compareTo(ans)  < 0){
                ans = rotated ;
            }
        }
        
        return ans  ;
    }
}