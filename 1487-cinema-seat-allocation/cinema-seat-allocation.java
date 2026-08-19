class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int a = reservedSeats.length ;
        HashMap<Integer , List<Integer>> map = new HashMap<>() ;
        for(int i = 0 ; i< a ;i++){
            int row = reservedSeats[i][0] ;
            int seat = reservedSeats[i][1] ;
            if(!map.containsKey(row)){
                map.put(row , new ArrayList<>()) ;
            }
            map.get(row).add(seat) ;
        }
        int ans = (n - map.size()) * 2  ;
        for(int s : map.keySet()){
            List<Integer> seats = map.get(s) ;
            boolean left = true ;
            boolean mid = true ;
            boolean right = true ;
            for(int c : seats){
                if(c >= 2  && c <= 5) left = false ;
                if(c >= 4 && c <= 7) mid = false  ;
                if(c >= 6 && c <= 9) right = false  ;
            }
            int count  ;
            if(left && right )  {
                count = 2 ;
            }
            else if(left || right || mid){
                count  = 1  ;
            }
            else{
                count = 0  ;
            }
            ans += count ;
        }
        return ans ;
    }
}