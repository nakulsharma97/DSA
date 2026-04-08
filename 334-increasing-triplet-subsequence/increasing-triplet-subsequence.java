class Solution {
    public boolean increasingTriplet(int[] nums) {
     int first = Integer.MAX_VALUE ;
     int sec = Integer.MAX_VALUE ;
     for(int num : nums){

        if(num <= first){
            first = num ;
        }
        else if( num <= sec){

            sec = num ;
        }
        else {
            return true ;
        }
     }   
     return false ; 
    }
}