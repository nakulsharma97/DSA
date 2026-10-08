class Solution {
    int n ;
    HashSet<String> res = new HashSet<>() ;
    int maxrem = Integer.MAX_VALUE ;
    public List<String> removeInvalidParentheses(String s) {
        n = s.length() ;
        
        dfs(0 , 0 , 0 , new StringBuilder() , s );
        return new ArrayList<>(res) ;
    }
    public void dfs(int ind , int balance , int removal , StringBuilder cur , String s){
         if (removal > maxrem) {
            return;
        }
        if(ind >= n){
            if(balance == 0){
                if(removal < maxrem){
                    maxrem = removal ;
                    res.clear();
                }
                if(removal == maxrem){
                    res.add(cur.toString()) ;
                }
            }
            return ;
        }
        if(s.charAt(ind) != '(' && s.charAt(ind) != ')'){
            cur.append(s.charAt(ind)) ;
            dfs(ind + 1, balance , removal  , cur , s) ;
            cur.deleteCharAt(cur.length() -1) ;
        }
       else  if(s.charAt(ind) == '('){
            dfs(ind + 1 , balance  , removal +1 , cur , s) ;
            cur.append(s.charAt(ind)) ;
            dfs(ind + 1 ,balance +1 ,removal  , cur, s) ;
            cur.deleteCharAt(cur.length() -1) ;
        }
        else {
            dfs(ind + 1 , balance , removal  +1 , cur , s ) ;
            if(balance > 0){
                cur.append(s.charAt(ind)) ;
                dfs(ind + 1 , balance - 1 , removal , cur , s) ;
                cur.deleteCharAt(cur.length()  -1) ;
            }
        }
    }
}