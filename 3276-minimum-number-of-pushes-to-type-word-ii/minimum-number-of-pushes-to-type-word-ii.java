class Solution {
    public int minimumPushes(String word) {
     int n = word.length() ;
     int freq[] = new int[26] ;
     for(int i = 0 ; i < n ;i++){
        char c = word.charAt(i) ;
         freq[c - 'a']++ ;
     }   
     int ans = 0 ;
     int cnt = 0 ;
     Arrays.sort(freq) ;
     for(int i = 25 ; i >= 0 ;i--){
        if(freq[i] == 0){
            break ;
        }
       ans = ans + freq[i] * (cnt / 8 + 1)  ;
       cnt++ ; 
     }
     return ans ;
    }
}