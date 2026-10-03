class Solution {
    public int longestValidParentheses(String s) {
        int n  = s.length() ;
        Stack<Integer> st = new Stack<>() ;
        st.push(-1) ;
        int ans =  0 ;
        for(int i = 0 ; i < n ;i++){
            char ch = s.charAt(i) ;
            if(ch == '('){
                st.push(i) ;
            }
            else {
                st.pop() ;
                if(st.isEmpty()){
                    st.push(i) ;
                }
                else {
                    ans = Math.max(ans , i - st.peek()) ;
                }
            }
        }
        return ans  ;
    }
}