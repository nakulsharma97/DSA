class Solution {
    public String smallestSubsequence(String s) {
     int n = s.length() ;
     Stack<Character> st = new Stack<>() ;
     boolean[]   vis = new boolean[27] ;
     int freq[] = new int[27] ;
     for(int i = 0 ; i < n ;i++){
        char ch = s.charAt(i) ;
        freq[ch  - 'a']++ ;
     }  
     for(int i = 0 ; i < n;i++){
        char ch = s.charAt(i) ;
        freq[ch - 'a']-- ;
        if(vis[ch - 'a']){
            continue ;
        }
        while(!st.isEmpty() && st.peek() > ch && freq[st.peek() - 'a'] > 0 ){
            vis[st.peek() - 'a'] = false ;
            st.pop() ;
        }
        st.push(ch) ;
        vis[ch - 'a'] = true ;
     }
     StringBuilder sb = new StringBuilder() ;
     for(char c : st){
        sb.append(c) ;
     }
     return sb.toString() ;
    }
}