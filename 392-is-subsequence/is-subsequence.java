class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        int a = 0;
        int p = 0;
        if (n > m) {
            return false;
        }
        for (int i = 0; i < m; i++) {
           if(p < n && s.charAt(p) == t.charAt(i)){
            p++ ;
           }

        }
        return n == p ;
    }
}