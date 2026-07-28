class Solution {
    public int longestPalindrome(String s) {
        int ans = 0 ;
        int freq[] = new int[128];
       // s = s.toLowerCase() ;
        for(char c : s.toCharArray()){
            freq[c]++ ;
        }
        for(int i = 0 ; i< 128 ;i++){
            while(freq[i] >= 2){
                ans += 2 ;
                freq[i] -= 2 ;
            }
        }
        for(int i = 0 ; i < 128 ;i++){
            if(freq[i] == 1){
                ans++ ;
                break ;
            }
        }
        return ans ;
    }
}