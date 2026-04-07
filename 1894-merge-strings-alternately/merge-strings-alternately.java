class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n = word1.length() ;
        int  m = word2.length() ;
        int k = 0 ;
        StringBuilder merge = new StringBuilder() ;
        int maxlength = Math.max(n , m) ;
        for(int i = 0 ;i < maxlength ;i++){
            if(i < n){
                merge.append(word1.charAt(i))  ;
            }
            if(i < m){
                merge.append(word2.charAt(i)) ;
            }
        }
        return merge.toString() ;
    }
}