class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int currmin = nums[0];
        int maxsum = nums[0];
        int currmax = nums[0];
        int minsum = nums[0];
        for (int i = 1; i < n; i++) {
            currmax = Math.max(nums[i], currmax + nums[i]);
            maxsum = Math.max(currmax, maxsum);
        }
        for (int i = 1; i < n; i++) {
            currmin = Math.min(nums[i], currmin + nums[i]);
            minsum = Math.min(currmin, minsum);
        }
        minsum = Math.abs(minsum);
        return Math.max(minsum, maxsum);
    }
}