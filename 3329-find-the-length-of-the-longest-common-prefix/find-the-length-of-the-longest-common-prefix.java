class Solution {
    public int digit(int x){
        int cnt = 0 ;
        while(x > 0){
            cnt++ ;
            x/= 10 ;
        }
        return cnt ;
    }
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> pref = new HashSet<>()  ;
        for(int num : arr1){
            int x = num ;
            while(x > 0){
                pref.add(x) ;
                x/= 10 ;
            }
        }

        int ans = 0 ;
        int len = 0 ;

        for(int num : arr2){
            int x = num ;
            len = digit(x) ;
            while( x > 0){
                if(pref.contains(x)){
                    ans = Math.max(ans , len) ;
                    break ;
                }
                x/= 10 ;
                len-- ;
            }
            

        }
        return ans ;

    }
}