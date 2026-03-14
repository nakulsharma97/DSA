class Solution {
    public boolean isPossible(long time, int height, int[] worker) {
long totalheight = 0 ;
        // now check
       for(int ele : worker){
        long k = (long)((Math.sqrt(1 + (8.0 * time)/ele) -1) / 2) ;
totalheight  += k ;
if(totalheight >= height)  return true ;
       }
       return false ;
    }

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long min = 1;
        long max = 0;
        long dummy = 0;
        // find max 
        for (int ele : workerTimes) {
            dummy = Math.max(ele, dummy);
        }
        // find range 
        for (int i = 1; i <= mountainHeight; i++) {
            max += dummy * i;
        }

        // apply binary search
        while (max > min) {
            // find mid 
            long mid = (min + max) / 2;
            if (isPossible(mid, mountainHeight, workerTimes)) {
                max = mid;
            } else {
                min = mid + 1;
            }

        }
        return min;

    }
}