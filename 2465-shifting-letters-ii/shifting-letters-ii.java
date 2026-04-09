class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int diff[] = new int[n];
        for (int ad[] : shifts) {
            int start = ad[0];
            int end = ad[1];
            int x = (ad[2] == 1) ? 1 : -1;

            diff[start] += x;
            if (end + 1 < n) {
                diff[end + 1] -= x;
            }

        }
        for(int i = 1 ; i < n ;i++){
            diff[i]  = diff[i]  + diff[i-1] ;
        }
        char cc[]  = new char[n] ;
        for(int i = 0  ;i < n ;i++){
            int shift = diff[i] % 26 ;
            if(shift < 0){
                shift = shift + 26 ;
            }
            int ab = s.charAt(i) - 'a' ;
            cc[i] = (char)((ab + shift) % 26 + 'a') ;

        }
        return new String(cc) ;
    }
}