class Solution {
    public int findContentChildren(int[] g, int[] s) {
     Arrays.sort(g)  ;
     Arrays.sort(s) ;
     int a = g.length ;
     int b = s.length  ;
     int count = 0;
     if(b == 0) return 0 ;
      int i = 0 , j = 0 ;
      while(i <  a && j < b){
        if(s[j] >= g[i]){
            count++ ;
            i++ ;
            j++ ;
        }
        else {
            j++ ;
        }
      }  
      return count ;
    }
}