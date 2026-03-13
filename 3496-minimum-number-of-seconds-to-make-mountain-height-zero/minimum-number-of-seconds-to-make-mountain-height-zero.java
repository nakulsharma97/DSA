class Solution {

    // Function to check if workers can build mountainHeight in 'mid' seconds
    private boolean check(long mid, int[] wt, int mh) {

        long totalHeight = 0;

        for (int t : wt) {

            // maximum layers a worker can build in 'mid' seconds
            long height = (long)((-1 + Math.sqrt(1 + 8.0 * mid / t)) / 2);

            totalHeight += height;

            if (totalHeight >= mh) {
                return true;
            }
        }

        return totalHeight >= mh;
    }

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {

        int min = Integer.MAX_VALUE;

        for (int t : workerTimes) {
            min = Math.min(min, t);
        }

        long left = 1;
        long right = (long) min * mountainHeight * (mountainHeight + 1) / 2;

        long ans = right;

        while (left <= right) {

            long mid = left + (right - left) / 2;

            if (check(mid, workerTimes, mountainHeight)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}