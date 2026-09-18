class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long sum =  0 ;
        long ans = Long.MIN_VALUE ;
        long pre[] = new long[k];
        Arrays.fill(pre, Long.MAX_VALUE);
        pre[0] =  0 ;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int rem = (i + 1) % k;
            if (pre[rem] != Long.MAX_VALUE) {
                ans = Math.max(ans, sum - pre[rem] );
            }
            pre[rem] = Math.min(pre[rem] , sum);
        }
        return ans;
    }
}