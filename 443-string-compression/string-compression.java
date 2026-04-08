class Solution {
    public int compress(char[] chars) {
        int n = chars.length ;
        int i = 0 ;
        int ind =  0 ;
        while( i < n){
            char curr = chars[i] ;
            int count = 0 ;
             while( i < n && curr == chars[i]){
                i++ ;
                count++ ;
             }
             chars[ind++] = curr ;
             if( count > 1){
                String st = String.valueOf(count) ;
                for(char s : st.toCharArray()){
                    chars[ind++] = s ;

                }
             }

        }
        return ind ;
    }
}