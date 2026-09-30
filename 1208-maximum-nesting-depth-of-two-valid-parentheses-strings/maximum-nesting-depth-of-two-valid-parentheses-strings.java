class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n  = seq.length() ;
        int ans [] = new int[n] ;
        int dep = 0 ;
        Stack<Character> s = new Stack<>() ;
        for(int i = 0 ; i < n ;i++){
            char ch  = seq.charAt(i) ;
            if(ch == '('){
                 s.push('(') ;
                 dep++ ;
                 ans[i] = dep % 2 ;   
            }
            if(ch == ')'){
                s.pop() ;
                ans[i] = dep % 2 ;
                dep-- ;
            
            }
        }
        return ans  ;
    }
}