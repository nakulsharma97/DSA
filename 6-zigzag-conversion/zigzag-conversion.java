class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1 || numRows >= s.length()){
            return s ;
        }
        int n = s.length() ;
        StringBuilder str = new StringBuilder() ;
        int cycle = 2 * numRows - 2  ;
        for(int i = 0; i < numRows ;i++){
            for(int j = i ; j < n ;j += cycle){
                str.append(s.charAt(j)) ;
                int sec = j + cycle - 2 * i  ;
                if(i != 0 && i != numRows - 1 && sec < n){
                    str.append(s.charAt(sec)) ;
                }
            }
        }
        return str.toString() ;
    }
}