class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length() ;
        char c[] = palindrome.toCharArray() ;
        for(int i = 0 ; i < n/2 ;i++){
            if(c[i] != 'a'){
                c[i] = 'a';
                return String.valueOf(c) ;
             }
        }
        c[n-1] = 'b' ;
        return n < 2 ? "" : String.valueOf(c) ;
    }
}