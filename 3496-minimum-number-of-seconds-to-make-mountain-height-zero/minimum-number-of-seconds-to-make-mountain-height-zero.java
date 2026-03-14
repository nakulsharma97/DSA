class Solution {
    public boolean isPossible(long time, int height, int[] worker) {

        // now check
        for (int i = 0; i < worker.length; i++) {
            long j = 1L;
            long curr = 0;
            while (height > 0 && curr + j * worker[i] <= time) {
                curr += j * worker[i];
                j++;
                height--;
            }
            if (height == 0)
                return true;

        }

return height == 0 ? true : false ;
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