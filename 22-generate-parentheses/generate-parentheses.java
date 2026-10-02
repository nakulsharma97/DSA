class Solution {
    List<String> res = new ArrayList<>() ;
    public List<String> generateParenthesis(int n) {
        if(n-- == 1){
            return List.of("()") ;
        }
        dfs(n , n , "(") ;
        return res ;
    }
    public void dfs(int a , int c , String s){
        if(a == 0 && c == 0){
            res.add(s + ")") ;
            return ;
        }
        if(a > 0){
            dfs(a-1 , c , s + "(") ;
        }
        if(c >= a){
            dfs(a , c-1 , s + ")") ;
        }
    }
}