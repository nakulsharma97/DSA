class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        StringBuilder ans = new StringBuilder() ;
        HashMap<String , String> map = new HashMap<>() ;
        int n = knowledge.size() ;
        for(List<String> a  : knowledge){
            map.put(a.get(0) , a.get(1)) ;
        }
        int b = s.length() ;
        for(int i =  0 ; i < b;i++){
            if(s.charAt(i) == '('){
                StringBuilder ss = new StringBuilder() ;
                i++ ;
                while(s.charAt(i) != ')'){
                  char c = s.charAt(i) ;
                  ss.append(c) ;
                  i++ ;
                }
                if(map.containsKey(ss.toString())){
                    ans.append(map.get(ss.toString())) ;
                }else {
                    ans.append('?') ;
                }
            }
            else {
                ans.append(s.charAt(i)) ;
            }
        }
        return ans.toString() ;
    }
}