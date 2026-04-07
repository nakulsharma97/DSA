class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
     int n = candies.length ;
     int maxx =  0 ;
     for(int i = 0  ;i < n ;i++){
        maxx = Math.max( maxx , candies[i]);
     }  
     List<Boolean> res = new ArrayList<>() ;

     for(int i = 0 ;i < n ;i++){

        if(candies[i] + extraCandies >= maxx){
            res.add(true) ;

        }
        else {
            res.add(false) ;
        }
     }
     return res ;


    }
}