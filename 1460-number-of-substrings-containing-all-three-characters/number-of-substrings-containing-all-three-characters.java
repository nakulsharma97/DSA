class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        int left = 0;
        int freq[] = new int[3];
        int right = 0 ;
        while (right < n) {
            int ch = s.charAt(right) - 'a';
            freq[ch]++ ;
            while(freq[0] > 0 && freq[1] > 0 && freq[2] > 0){
              ans += n  - right ;
              freq[s.charAt(left) - 'a']-- ;
              left++ ;
            }
            right++ ;
        }
     return ans  ;
    }
}