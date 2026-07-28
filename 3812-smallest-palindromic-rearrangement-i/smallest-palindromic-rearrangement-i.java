class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length() ;
        char ans[] = new char[n] ;
        int freq[] = new int[26] ;
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++ ;
        }
        int left = 0 ;
        int right = n -1  ;
        for(int i = 0 ; i < 26 ;i++){
            while(freq[i] >= 2){
             ans[left++] = (char) ('a' + i)  ;
             ans[right--] = (char) ('a' + i) ;
             freq[i] -= 2 ;
            }
        }
        for(int i = 0 ; i< 26 ;i++){
            if(freq[i] == 1){
                ans[left]  = (char) ('a' + i) ;
                break ;
            }
        }
        return new String(ans) ;
            }
}