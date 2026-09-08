class Solution {
    public int compress(char[] chars) {
        int n  = chars.length ;
        int i =  0 ;
        int index =  0 ;
        while(i < n){
            char ch = chars[i] ;
            int len = 0 ;
            while(i <  n && chars[i] == ch){
                i++ ;
                len++ ;
            }
            chars[index++] = ch  ;
            if(len > 1){
                String num = String.valueOf(len) ;
                for(char c : num.toCharArray()){
                    chars[index++] = c ;
                }
            }


        }
        return index  ;
    }
}