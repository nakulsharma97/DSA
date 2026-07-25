class Solution {
    public boolean check(String a, String b) {
        int aa = a.length();
        int bb = b.length();
        if (aa != bb + 1)
            return false;
        int i = 0;
        int j = 0;
        while (aa > i && j < bb) {
            if (a.charAt(i) == b.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == bb;
    }

    public int longestStrChain(String[] words) {
        int n = words.length  ;
        int t[] = new int[n] ;
        int max = 1 ;
       Arrays.sort(words , (a , b) -> a.length() - b.length()) ;
        for(int i = 0 ; i < n ;i++){
            t[i] = 1  ;
        }
        for(int i = 0 ; i< n;i++){
            for(int j = 0 ; j < i ;j++){
                 if(words[i].length() == words[j].length() + 1
        && check(words[i], words[j])) {
                 t[i] = Math.max(t[i] , t[j] +1) ;
                 max = Math.max(max , t[i]) ;
                }
            }
        }

        return max  ;
    }
}