class Solution {
    int n ;
    HashSet<String> res = new HashSet<>() ;
    int min = Integer.MAX_VALUE ;
    public List<String> removeInvalidParentheses(String s) {
        n = s.length() ;
        dfs(0 , 0 , 0 , new StringBuilder() , s) ;
        return new ArrayList<>(res) ; 
    }
    public void dfs(int ind , int balance , int removal , StringBuilder cur , String s){
        if(removal > min){
            return ;
        }
        if(ind >= n){
            if(balance == 0){
                if(removal < min){
                    min = removal ;
                    res.clear() ;
                }
                if(min == removal){
                    res.add(cur.toString()) ;
                }
            }
            return ;
        }
        char ch = s.charAt(ind) ;
        if(ch != '(' && ch != ')'){
            cur.append(ch) ;
            dfs(ind + 1 , balance , removal , cur , s) ;
            cur.deleteCharAt(cur.length() -1) ;
        }
        else if(ch == '('){
            dfs(ind + 1 , balance , removal +1 , cur , s) ;
            cur.append(ch) ;
            dfs(ind + 1 , balance +1 , removal ,cur ,s) ;
            cur.deleteCharAt(cur.length() -1) ;
        }
        else {
            dfs(ind + 1 , balance , removal + 1 , cur , s) ;
            if(balance > 0){
                cur.append(ch) ;
                dfs(ind + 1 , balance -1 , removal , cur ,s) ;
                cur.deleteCharAt(cur.length() -1) ;
            }
        }
    }
}