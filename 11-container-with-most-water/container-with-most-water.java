class Solution {
    public int maxArea(int[] height) {
        int n = height.length ;
        int i = 0 ;
        int p = n - 1 ;
        int area = 0 ;
        int width = 0 ; 
        while( i < p){
            int h = Math.min(height[i]   , height[p]) ;
            width = p -i ;
            area = Math.max( area , width * h) ;

            if(height[i]  <height[p]){
                i++ ;
            }
            else {
                p-- ;
            }

        }
        return area ;
    }
}