class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        int n = asteroids.length ;
        Arrays.sort(asteroids) ;
        long curr = mass ;
        for(int i = 0 ;i < n ;i++){
            if(curr < asteroids[i]){
                return false ;
            }
            else {
                curr = curr + asteroids[i] ;
            }

        }
        return true ;
    }
}