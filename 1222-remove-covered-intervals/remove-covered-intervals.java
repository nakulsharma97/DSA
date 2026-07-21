class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
     Arrays.sort(intervals , (a , b) -> (a[0] == b[0]) ? b[1] - a[1]  : a[0] - b[0])   ;
     int count =0 ;
     int max  =  0;
     for(int it[]  : intervals){
        if(it[1] > max){
            max = it[1] ;
            count++ ;
        }
     } 
     return count ;
    }
}