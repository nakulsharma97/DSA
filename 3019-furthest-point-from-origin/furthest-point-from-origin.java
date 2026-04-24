class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int n = moves.length();
        int res = 0;
        int sym = 0 ;
        for (int i = 0; i < n; i++) {
            if (moves.charAt(i) == 'L') {
                res += -1;
            } else if(moves.charAt(i) == 'R'){

                res += 1 ;
            }
            else {
                sym += 1 ;

            }
        }
        int ans = Math.max(res + sym , Math.abs(res - sym)) ;
        return  Math.abs(ans) ;
    }
}