class Solution {
    public List<String> getchild(String s){
        List<String> l = new ArrayList<>() ;
        char arr[] = s.toCharArray() ;
        for(int i = 0 ; i < 4 ;i++){
            char c = s.charAt(i) ;
            arr[i] = (char) ( '0' + (((c - '0') + 1) % 10)) ;
            l.add(new String (arr)) ;
            arr[i] = (char) ('0' + (((c - '0') + 9 ) % 10)) ;
            l.add(new String (arr)) ;
            arr[i] = c ;
        }
        return l  ;
    }
    public int openLock(String[] deadends, String target) {
        HashSet<String> set = new HashSet<>() ;
        int n = deadends.length ;
        for(String s : deadends){
            if(s.equals("0000")){
                return -1  ;
            }
            set.add(s) ;
        }
        if(target.equals("0000")){
            return  0 ;
        }
        Queue<String> q = new LinkedList<>() ;
        q.offer("0000")  ;
        int d =  1 ;
        while(!q.isEmpty()){
            int size = q.size() ;
            while(size-- > 0){
                String node = q.poll() ;
                for(String s : getchild(node)){
                    if(set.contains(s)){
                        continue ;
                    }
                    if(target.equals(s)){
                        return d ;
                    }
                    set.add(s) ;
                    q.offer(s) ;
                }
            }
            d++ ;
        }
        return -1 ;
    }
}