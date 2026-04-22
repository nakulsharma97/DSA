class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res = new ArrayList<>() ;
        for(String q : queries){
            if(hasmatch(q , dictionary)){
                res.add(q) ;
            }
        }
        return res ;
    }
    public boolean hasmatch(String q , String[] dictionary){
boolean found = false ;
        for(String dic : dictionary){
            int diff = 2 ;
            for(int i = 0 ;i < dic.length() ;i++){
                if(q.charAt(i)  != dic.charAt(i)){
                    diff--;
                }
                if(diff < 0){

                    break;
                }
            }
            if(diff >= 0){
                return true ;
            }

        }
        return false ;
    }
}