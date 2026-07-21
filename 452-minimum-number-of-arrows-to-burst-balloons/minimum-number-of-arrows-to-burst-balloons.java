class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length ;
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        if(n == 0){
            return 0 ;
        }
        int count = 1 ;
        int max = points[0][1] ;
        for(int i = 1 ; i< n ;i++){
            if(max >= points[i][0]){
                continue ;
            }
            count++ ;
            max = points[i][1] ;
        }
        return count ;
    }
}